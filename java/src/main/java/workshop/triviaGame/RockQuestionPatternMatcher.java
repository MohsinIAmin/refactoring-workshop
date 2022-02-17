package workshop.triviaGame;

public class RockQuestionPatternMatcher implements QuestionPatternMatcher{
    @Override
    public boolean match(int number) {
        return true;
    }

    @Override
    public String generateResponse() {
        return "Rock";
    }
}
