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
}
