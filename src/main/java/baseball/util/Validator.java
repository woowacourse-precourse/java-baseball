package baseball.util;

import baseball.constant.GameConstant;
import baseball.constant.WarningMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void isDigit(char ch) {
        if(! Character.isDigit(ch)) {
            throw new IllegalArgumentException(WarningMessage.IllegalInputWarningMessage.getMessage());
        }
    }

    public static void isValidNumber(List<Integer> numbers) {
        isBetweenOneAndNine(numbers);
        isExistDuplicateNumber(numbers);
        isThreeDigits(numbers);
    }

    private static void isBetweenOneAndNine(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < 1 || 9 < number) {
                throw new IllegalArgumentException(WarningMessage.IllegalValueWarningMessage.getMessage());
            }
        }
    }

    private static void isExistDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() < GameConstant.DIGIT.getValue()) {
            throw new IllegalArgumentException(WarningMessage.DuplicateValueWarningMessage.getMessage());
        }
    }

    private static void isThreeDigits(List<Integer> numbers) {
        if(numbers.size() != 3) {
            throw new IllegalArgumentException(WarningMessage.IllegalInputWarningMessage.getMessage());
        }
    }
}
