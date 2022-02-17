package workshop.plaintextToHtmlConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PlaintextToHtmlConverter {
    private String source;
    private String file_path="sample.txt";
    private String convertedHtml;

    private List<PatternMatcher> patternMatchers;
    private PatternMatcher nullObjectMatcher;

    public PlaintextToHtmlConverter(List<PatternMatcher> patternMatchers, PatternMatcher nullObjectMatcher) {
        this.patternMatchers = patternMatchers;
        this.nullObjectMatcher = nullObjectMatcher;
    }

    public String toHtml() throws IOException {
        this.source = read();
        return basicHtmlEncode();
    }
    /*
    * read method should not be in this class
    * a utility class is more preferable
    * file_path will also go there
    * */
    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(file_path)));
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getConvertedHtml() {
        return convertedHtml;
    }

    private String basicHtmlEncode() {
        convertedHtml=nullObjectMatcher.generateResponse();
        for(char conv:source.toCharArray()){
            String characterToConvert = String.valueOf(conv);
            for (workshop.plaintextToHtmlConverter.PatternMatcher patternMatcher : patternMatchers) {
                if (patternMatcher.matches(characterToConvert)) {
                    convertedHtml = convertedHtml.concat(patternMatcher.generateResponse());
                    break;
                }
            }
        }
        return convertedHtml;
    }
}
