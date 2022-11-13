package baseball.user.validation;

import baseball.rule.NumberConstant;
import java.util.stream.Stream;

public class UserValidation {
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
        if (userInput.length() != NumberConstant.NUMBER_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_LENGTH);
        }
    }

    public static void validateNumberRange(String userInput) {
        boolean correctRange = Stream.of(userInput.split(""))
            .mapToInt(Integer::parseInt)
            .allMatch((number) -> (number <= NumberConstant.MAX_DIGIT) && (number >= NumberConstant.MIN_DIGIT));
        if (!correctRange) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE);
        }
    }
}
