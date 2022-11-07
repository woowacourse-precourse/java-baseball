package baseball;

import java.util.ArrayList;
import java.util.List;

public class BallCountGuess {
    private static final int CHECK_VALUE = -2;
    private final InputValidator inputValidator = new InputValidator();
    private final List<Integer> guessValue;

    public BallCountGuess(String input) {
        inputValidator.validateGuessValueMessage(input);
        guessValue = new ArrayList<>();
        for (int i = 0; i < GamePlayer.DIGIT_NUMBER; i++) {
            guessValue.add(input.charAt(i) - '0');
        }
    }

    public Integer get(int index) {
        return guessValue.get(index);
    }

    public List<Integer> getAll() {
        return new ArrayList<>(guessValue);
    }

    public void check(int index) {
        guessValue.set(index, CHECK_VALUE);
    }

}
