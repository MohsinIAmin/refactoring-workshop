package workshop.plaintextToHtmlConverter;

public class NewLinePatternMatcher implements PatternMatcher{
    @Override
    public boolean matches(String plainText) {
        return plainText.equals("\n");
    }

    @Override
    public String generateResponse() {
        return "<br />";
    }
}
