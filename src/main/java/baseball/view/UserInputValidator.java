package baseball.view;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInputValidator {

    private static final Integer INPUT_LENGTH = 3;

    public static void validateAnswer(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 다시 입력해주세요");
        }

        if (
            !isNumeric(input) ||
            !isNotContainZero(input) ||
            !isThreeWord(input) ||
            !isDifferentEachOther(input, INPUT_LENGTH)) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 다시 입력해주세요");
        }
    }

    public static void validateReStart(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 다시 입력해주세요");
        }

        if (!isNumeric(input) || !isOneOrTwo(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 다시 입력해주세요");
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOneOrTwo(String input) {
        int reStart = Integer.parseInt(input);

        return reStart == 1 || reStart == 2;
    }

    private static boolean isThreeWord(String input) {
        return input.length() == 3;
    }

    private static boolean isDifferentEachOther(String input, int length) {
        Set<String> digits = Arrays.stream(input.split(""))
                .collect(Collectors.toUnmodifiableSet());

        return length == digits.size();
    }

    private static boolean isNotContainZero(String input) {
        return Arrays.stream(input.split("")).noneMatch(s -> s.equals("0"));
    }
}
