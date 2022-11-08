package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> guessedAnswer;

    public User() {
        initGuessedAnswer();
    }

    public void initGuessedAnswer() {
        guessedAnswer = new ArrayList<>();
    }

    public void setGuessedAnswer(String stringGuessedAnswer) {
        initGuessedAnswer();

        for (char charNumber : stringGuessedAnswer.toCharArray()) {
            int number = Character.getNumericValue(charNumber);
            guessedAnswer.add(number);
        }
    }

    public List<Integer> getGuessedAnswer() {
        return guessedAnswer;
    }
}
