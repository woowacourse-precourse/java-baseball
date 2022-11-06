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
        return inputString.length() == Ball.COUNT.getValue();
    }

    public static boolean isInRange(List<Integer> numberList) {
        return numberList.stream()
                .allMatch(num -> num >= Ball.MIN.getValue() && num <= Ball.MAX.getValue());
    }

    public static boolean isNotDuplicate(List<Integer> numberList) {
        long removeDuplicateCount = numberList.stream()
                .distinct()
                .count();
        return removeDuplicateCount == Ball.COUNT.getValue();
    }
}
