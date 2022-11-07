package baseball;

import static baseball.Constant.MAX_LENGTH;

public class Validator {
    public void isNumeric(String input) throws IllegalArgumentException {
        try {
            Double.parseDouble(input);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("input is now numeric.");
        }
    }

    public void checkGuessLength(String input) throws IllegalArgumentException {
        if(input.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("guess only 3 numbers.");
        }
    }

    public void checkRange(int input) throws IllegalArgumentException {
        if(input < 1 || input > 9 ) {
            throw new IllegalArgumentException("guess between 1 ~ 9.");
        }
    }
}
