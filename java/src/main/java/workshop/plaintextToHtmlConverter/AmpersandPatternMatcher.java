package workshop.plaintextToHtmlConverter;

public class AmpersandPatternMatcher implements PatternMatcher{
    @Override
    public boolean matches(String plainText) {
        return plainText.equals("&");
    }

    @Override
    public String generateResponse() {
        return "&amp;";
    }
}
