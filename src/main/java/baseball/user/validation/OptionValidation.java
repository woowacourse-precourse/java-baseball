package baseball.user.validation;

public class OptionValidation {
    private static final int OPTION_LENGTH = 1;
    public static void validate(String userInput) {
        validateLength(userInput);
    }

    public static void validateLength(String userInput) {
        if (userInput.length() != OPTION_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.OPTION_LENGTH);
        }
    }
}
