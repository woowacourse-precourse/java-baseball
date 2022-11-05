package baseball.validator;

import java.util.stream.Collectors;

import static baseball.validator.NumberStatus.*;

public class NumberValidator {
    private static final int NUMBER = 3;

    public static void validate(String userNumber) throws IllegalArgumentException {
        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException(NO_NUMBER.getMessage());
        }
        if (!isThreeDigitNumber(userNumber)) {
            throw new IllegalArgumentException(NO_THREE_DIGIT.getMessage());
        }
        if (isOverlap(userNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER.getMessage());
        }
        if (isContainsZero(userNumber)) {
            throw new IllegalArgumentException(NO_CONTAIN_ZERO.getMessage());
        }
    }

    private static boolean isContainsZero(String userNumber) {
        return userNumber.contains("0");
    }

    private static boolean isOverlap(String userNumber) {
        return userNumber.chars().mapToObj(i -> (char) i).collect(Collectors.toSet()).size() != NUMBER;
    }

    private static boolean isThreeDigitNumber(String userNumber) {
        return userNumber.length() == NUMBER;
    }

    private static boolean isNumber(String userNumber) {
        return userNumber.chars().allMatch(Character::isDigit);
    }

    public static void number(String userChoice) {
        if (!userChoice.equals("1") && !userChoice.equals("2")) {
            throw new IllegalArgumentException(WRONG_NUMBER.getMessage());
        }
    }
}