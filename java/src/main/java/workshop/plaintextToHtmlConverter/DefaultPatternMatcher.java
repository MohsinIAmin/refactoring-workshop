package workshop.plaintextToHtmlConverter;

public class DefaultPatternMatcher implements PatternMatcher{
    private String strReturn;
    @Override
    public boolean matches(String plainText) {
        this.strReturn = plainText;
        return true;
    }

    @Override
    public String generateResponse() {
        return this.strReturn;
    }
}
