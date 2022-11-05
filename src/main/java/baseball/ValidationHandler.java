package baseball;

public class ValidationHandler {

    private static final int NUMBER_LENGTH = 3;
    private static final String REGEX_NOT_NUMBER = "^\\d";

    ValidationHandler() {
    }

    public boolean validateLength(String inputValue) {
        return inputValue.length() == NUMBER_LENGTH;
    }

    public boolean isNumber(String inputValue) {
        return inputValue.matches(REGEX_NOT_NUMBER);
    }
}
