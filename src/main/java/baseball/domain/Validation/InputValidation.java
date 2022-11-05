package baseball.domain.Validation;

import java.util.List;

public class InputValidation {
    private static final String NUMBER_REGEX = "[0-9]+";

    private InputValidation() {
    }

    public static boolean hasOnlyNumbers(String inputString) {
        return inputString.matches(NUMBER_REGEX);
    }

    public static boolean is3Numbers(String inputString) {
        return inputString.length() == BallNumber.NUMBER_LENGTH.getValue();
    }

    public static boolean isInRange(List<Integer> numberList) {
        return numberList.stream()
                .allMatch(num -> num >= BallNumber.NUMBER_MIN.getValue() && num <= BallNumber.NUMBER_MAX.getValue());
    }

    public static boolean isNotDuplicate(List<Integer> numberList) {
        long removeDuplicateCount = numberList.stream()
                .distinct()
                .count();
        return removeDuplicateCount == BallNumber.NUMBER_LENGTH.getValue();
    }
}
