package baseball.domain.Validation;

import static baseball.StringEnum.InputExceptionCode.*;

import java.util.List;

public class InputValidation {
    private static final String NUMBER_REGEX = "[0-9]+";

    private InputValidation() {
    }

    public static void validateBallInputFormat(String inputString) {
        if (!InputValidation.hasOnlyNumbers(inputString)) {
            throw new IllegalArgumentException(NOT_NUMBER_INCLUDE.toString());
        }

        if (!InputValidation.is3Numbers(inputString)) {
            throw new IllegalArgumentException(NOT_3_NUMBERS.toString());
        }
    }

    public static void validateBallInputNumber(List<Integer> ballNumbers) {
        if (!InputValidation.isInRange(ballNumbers)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.toString());
        }

        if (!InputValidation.isNotDuplicate(ballNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.toString());
        }
    }

    public static void validateRestartInput(String inputString) {
        if (!InputValidation.hasOnlyNumbers(inputString)) {
            throw new IllegalArgumentException(NOT_RESTART_NUMBER.toString());
        }
    }

    public static boolean validateIsRestart(int restartNumber) {
        Boolean isRestart = Restart.isRestart(restartNumber);
        if (isRestart == null) {
            throw new IllegalArgumentException(NOT_RESTART_NUMBER.toString());
        }
        return isRestart;
    }

    private static boolean hasOnlyNumbers(String inputString) {
        return inputString.matches(NUMBER_REGEX);
    }

    private static boolean is3Numbers(String inputString) {
        return inputString.length() == Ball.COUNT.getValue();
    }

    private static boolean isInRange(List<Integer> numberList) {
        return numberList.stream()
                .allMatch(num -> num >= Ball.MIN.getValue() && num <= Ball.MAX.getValue());
    }

    private static boolean isNotDuplicate(List<Integer> numberList) {
        long removeDuplicateCount = numberList.stream()
                .distinct()
                .count();
        return removeDuplicateCount == Ball.COUNT.getValue();
    }
}
