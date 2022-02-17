package workshop.triviaGame;

public interface QuestionPatternMatcher {
    boolean match(int number);
    String generateResponse();
}
