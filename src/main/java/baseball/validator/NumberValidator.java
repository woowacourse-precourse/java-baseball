package baseball.validator;

import java.util.stream.Collectors;

public class NumberValidator {

    public static void validate(String userNumber) {
        if (!userNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (userNumber.chars().mapToObj(i -> (char) i).collect(Collectors.toSet()).size() != 3) {
            throw new IllegalArgumentException();
        }

    }
}
