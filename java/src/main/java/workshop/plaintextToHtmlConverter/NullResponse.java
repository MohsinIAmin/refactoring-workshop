package workshop.plaintextToHtmlConverter;

public class NullResponse implements PatternMatcher{
    @Override
    public boolean matches(String plainText) {
        return false;
    }

    @Override
    public String generateResponse() {
        return "";
    }
}
