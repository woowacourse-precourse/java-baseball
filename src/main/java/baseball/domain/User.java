package baseball.domain;

public class User {

    private static final int GUESSED_ANSWER_LENGTH = 3;
    private final Integer[] guessedAnswer;

    public User() {
        this.guessedAnswer = new Integer[GUESSED_ANSWER_LENGTH];
    }

    public void setGuessedAnswer(String guessedAnswer) {
        for (int i = 0; i < GUESSED_ANSWER_LENGTH; i++) {
            char number = guessedAnswer.charAt(i);
            this.guessedAnswer[i] = Character.getNumericValue(number);
        }
    }

    public Integer[] getGuessedAnswer() {
        return guessedAnswer;
    }
}
