package baseball.validation;

public class InputValidation {
    public boolean isNotThreeLetters(String input) {
        return input.length() != 3;
    }
}
