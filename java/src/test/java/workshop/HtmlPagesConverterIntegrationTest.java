package workshop;

import org.junit.Test;
import workshop.plaintextToHtmlConverter.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlPagesConverterIntegrationTest {
    @Test
    public void convertFromActualFile() throws Exception {
        List<PatternMatcher> patternMatcherList = Arrays.asList(
                new LessThenPatternMatcher(),
                new GreaterThenPatternMatcher(),
                new AmpersandPatternMatcher(),
                new NewLinePatternMatcher(),
                new DefaultPatternMatcher()
        );
        PatternMatcher nullObjectMatcher = new NullResponse();

        PlaintextToHtmlConverter converter = new PlaintextToHtmlConverter(patternMatcherList,nullObjectMatcher);
        assertEquals("abc<br />&lt;hello&gt;", converter.toHtml());
    }
}
