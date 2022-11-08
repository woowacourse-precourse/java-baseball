package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public void validateIsDigit(Character number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumber(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException();
        }
    }

    public void validateLength(String numbers, int length) {
        if (numbers.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(String numbers) {
        Set<Character> uniqueNumbers = new HashSet<>();
        for (char number : numbers.toCharArray()) {
            uniqueNumbers.add(number);
        }
        if (uniqueNumbers.size() != Constant.LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
