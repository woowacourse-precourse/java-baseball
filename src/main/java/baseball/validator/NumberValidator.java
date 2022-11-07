package baseball.validator;

import java.util.stream.Collectors;

import static baseball.validator.NumberStatus.*;

public class NumberValidator {
    private static final int USER_ANSWER_LENGTH_LIMIT = 3;
    private static final String RESTART_NUMBER = "1";
    private static final String EXIT_NUMBER = "2";
    private static final String ZERO = "0";

    public static void validateUserAnswer(String userAnswer) throws IllegalArgumentException {
        if (!isNumber(userAnswer)) {
            throw new IllegalArgumentException(NO_NUMBER.getMessage());
        }
        if (!isThreeDigitNumber(userAnswer)) {
            throw new IllegalArgumentException(NO_THREE_DIGIT.getMessage());
        }
        if (isOverlap(userAnswer)) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER.getMessage());
        }
        if (isContainsZero(userAnswer)) {
            throw new IllegalArgumentException(NO_CONTAIN_ZERO.getMessage());
        }
    }

    private static boolean isContainsZero(String userNumber) {
        return userNumber.contains(ZERO);
    }

    private static boolean isOverlap(String userNumber) {
        return userNumber.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toSet()).size() != USER_ANSWER_LENGTH_LIMIT;
    }

    private static boolean isThreeDigitNumber(String userNumber) {
        return userNumber.length() == USER_ANSWER_LENGTH_LIMIT;
    }

    private static boolean isNumber(String userNumber) {
        return userNumber.chars().allMatch(Character::isDigit);
    }

    public static void validateRestartChoice(String userChoice) {
        if (!userChoice.equals(RESTART_NUMBER) && !userChoice.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException(WRONG_NUMBER.getMessage());
        }
    }
}