package workshop;

import org.junit.Test;
import workshop.plaintextToHtmlConverter.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlPagesConverterTest {
    List<PatternMatcher> patternMatcherList = Arrays.asList(
            new LessThenPatternMatcher(),
            new GreaterThenPatternMatcher(),
            new AmpersandPatternMatcher(),
            new NewLinePatternMatcher(),
            new DefaultPatternMatcher()
    );
    PatternMatcher nullObjectMatcher = new NullResponse();

    PlaintextToHtmlConverterFake converter = new PlaintextToHtmlConverterFake(patternMatcherList,nullObjectMatcher);

    @Test
    public void charConversion() throws Exception {
        converter.setRead("<");
        assertEquals("&lt;", converter.toHtml());

        converter.setRead(">");
        assertEquals("&gt;", converter.toHtml());

        converter.setRead("&");
        assertEquals("&amp;", converter.toHtml());

        converter.setRead("\n");
        assertEquals("<br />", converter.toHtml());
    }

    @Test
    public void noConversion() throws Exception {
        converter.setRead("simple");
        assertEquals("simple", converter.toHtml());
    }

    @Test
    public void mixedCharConversion() throws Exception {
        converter.setRead("<small>\n&space");
        assertEquals("&lt;small&gt;<br />&amp;space", converter.toHtml());
    }

    class PlaintextToHtmlConverterFake extends PlaintextToHtmlConverter {
        public PlaintextToHtmlConverterFake(List<PatternMatcher> patternMatchers, PatternMatcher nullObjectMatcher){
            super(patternMatchers,nullObjectMatcher);
        }
        String text;
        protected void setRead(String text) {
            this.text = text;
        }
        @Override
        protected String read() throws IOException {
            return text;
        }
    }
}
