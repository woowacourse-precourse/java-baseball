package baseball.validator;

import java.util.stream.Collectors;

public class NumberValidator {

    public static void validate(String userNumber) {
        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException("Only numbers can be entered.");
        }
        if (!isThreeDigitNumber(userNumber)) {
            throw new IllegalArgumentException("It's not a three-digit number.");
        }
        if (isOverlap(userNumber)) {
            throw new IllegalArgumentException("Duplicate numbers cannot be entered.");
        }
    }

    private static boolean isOverlap(String userNumber) {
        return userNumber.chars().mapToObj(i -> (char) i).collect(Collectors.toSet()).size() != 3;
    }

    private static boolean isThreeDigitNumber(String userNumber) {
        return userNumber.length() == 3;
    }

    private static boolean isNumber(String userNumber) {
        return userNumber.chars().allMatch(Character::isDigit);
    }

}