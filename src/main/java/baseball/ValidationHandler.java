package baseball;

public class ValidationHandler {

    private static final int NUMBER_LENGTH = 3;
    private static final String REGEX_NOT_NUMBER = "^\\d";

    ValidationHandler() {
    }

    public void validateLength(String inputValue) {
        if(inputValue.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("number length must be 3");
        }
    }

    public void validateNumber(String inputValue) {
        if(inputValue.matches(REGEX_NOT_NUMBER)) {
            throw new IllegalArgumentException("input value must be number");
        }
    }
}
