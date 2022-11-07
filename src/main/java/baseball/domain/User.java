package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int GUESSED_ANSWER_LENGTH = 3;

    private List<Integer> guessedAnswer;

    public User() {
        initguessedAnswer();
    }

    public void initguessedAnswer() {
        guessedAnswer = new ArrayList<>();
    }

    public void setGuessedAnswer(String guessedAnswer) {
        initguessedAnswer();

        for (int i = 0; i < GUESSED_ANSWER_LENGTH; i++) {
            char charNumber = guessedAnswer.charAt(i);
            int number = Character.getNumericValue(charNumber);
            this.guessedAnswer.add(number);
        }
    }

    public List<Integer> getGuessedAnswer() {
        return guessedAnswer;
    }
}
