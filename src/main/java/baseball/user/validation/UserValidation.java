package baseball.user.validation;

import java.util.stream.Stream;

public class UserValidation {

    private static final int NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEXP = "^[0-9]+$";

    public static void validate(String userInput) {
        validateOnlyNumber(userInput);
        validateNumberLength(userInput);
        validateNumberRange(userInput);
    }

    public static void validateOnlyNumber(String userInput) {
        if (!userInput.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_NUMBER);
        }
    }

    public static void validateNumberLength(String userInput) {
        if (userInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_LENGTH);
        }
    }

    public static void validateNumberRange(String userInput) {
        boolean correctRange = Stream.of(userInput.split(""))
            .mapToInt(Integer::parseInt)
            .allMatch((number) -> (number <= 9) && (number >= 1));
        if (!correctRange) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE);
        }
    }
}
