package baseball.domain.Validation;

import java.util.List;

public class InputValidation {
    private static final String NUMBER_REGEX = "[0-9]+";

    private InputValidation() {
    }

    // 예외 처리 추가 필요
    public static boolean hasOnlyNumbers(String inputString) {
        return inputString.matches(NUMBER_REGEX);
    }

    public static boolean is3Numbers(String inputString) {
        return inputString.length() == 3;
    }

    public static boolean isInRange(List<Integer> numberList) {
        return numberList.stream()
                .allMatch(num -> num >= 1 && num <= 9);
    }

    public static boolean isNotDuplicate(List<Integer> numberList) {
        long removeDuplicateCount = numberList.stream()
                .distinct()
                .count();
        return removeDuplicateCount == 3;
    }
}
