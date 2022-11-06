package baseball.utils;

import java.util.Collections;
import java.util.List;

public class IsCollection {
    public static boolean isInputNumbersInRange(String inputNumbers, int start, int end) {
        for (int index = 0; index < inputNumbers.length(); index++) {

            int number = Integer.parseInt(inputNumbers.substring(index, index + 1));

            if (!isValueInRange(number, start, end)) {
                return false;
            }
        }

        return true;
    }

    public static boolean hasNumber(List<Integer> numbers, int number) {
        for (int index = 0; index < numbers.size(); index++) {
            if (isSameValue(number, numbers.get(index))) {
                return true;
            }
        }

        return false;
    }

    public static boolean isDuplication(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    //TODO : 메소드명 변경
    public static boolean isEqualToSetCount(List<Integer> numbers, int count) {
        return numbers.size() == count;
    }

    //TODO : 메소드명 변경
    public static boolean isEqualToSetLength(String inputNumber, int length) {
        return inputNumber.length() == length;
    }

    public static boolean isValueInRange(int value, int start, int end) {
        return value >= start && value <= end;
    }

    public static boolean isSameValue(int numberA, int numberB) {
        return numberA == numberB;
    }
}
