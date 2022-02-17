package workshop.plaintextToHtmlConverter;

public interface PatternMatcher {
    boolean matches(String plainText);
    String generateResponse();
}
