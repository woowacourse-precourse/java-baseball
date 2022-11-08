package baseball.option.validation;


import baseball.option.Option;

public class OptionValidation {
    private static final int OPTION_LENGTH = 1;
    public static void validate(String userInput) {
        validateLength(userInput);
        validateOption(userInput);
    }

    private static void validateLength(String userInput) {
        if (userInput.length() != OPTION_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.OPTION_LENGTH);
        }
    }

    private static void validateOption(String userInput) {
        int option = Integer.parseInt(userInput);

        if ((option != Option.RESTART.getOption()) && (option != Option.END.getOption())) {
            throw new IllegalArgumentException(ExceptionMessage.OPTION_TYPE);
        }
    }
}
