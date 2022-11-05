package baseball;

public class ValidationHandler {

    private static final int NUMBER_LENGTH = 3;
    private static final String REGEX_NOT_NUMBER = "^\\d";
    private final String inputString;

    ValidationHandler(String inputString) {
        this.inputString = inputString;
    }

    public boolean validateNumberLength() {
        if (inputString.length() == NUMBER_LENGTH) {
            return true;
        }

        return false;
    }

    public boolean isNumber() {
        return inputString.matches(REGEX_NOT_NUMBER);
    }
}
