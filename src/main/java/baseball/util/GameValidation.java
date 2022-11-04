package baseball.util;

import java.util.stream.Collectors;

public class GameValidation {

    private final static int GAME_NUMBER_LENGTH = 3;
    private final static char START_RANGE = '1';
    private final static char END_RANGE = '9';

    private GameValidation() {
    }

    public static void validate(String input) {
        if (isInvalidLength(input)) {
            throw new IllegalArgumentException(
                GAME_NUMBER_LENGTH + "자리 입력이 필요합니다. 입력 길이: " + input.length());
        }

        if (containsNotDigit(input)) {
            throw new IllegalArgumentException(
                "숫자가 아닌 문자가 포함되어 있습니다. 입력: " + input);
        }

        if (containsInvalidRangeDigit(input)) {
            throw new IllegalArgumentException(
                START_RANGE + "~" + END_RANGE + "범위를 벗어난 숫자가 포함되어 있습니다. 입력: " + input);
        }

        if (containsDuplication(input)) {
            throw new IllegalArgumentException(
                "중복되는 숫자가 포함되어 있습니다. 입력: " + input);
        }
    }

    public static boolean isInvalidLength(String input) {
        return input.length() != GAME_NUMBER_LENGTH;
    }

    public static boolean containsNotDigit(String input) {
        return input.chars()
            .anyMatch(GameValidation::isNotDigit);
    }

    private static boolean isNotDigit(int codePoint) {
        return !Character.isDigit(codePoint);
    }

    public static boolean containsInvalidRangeDigit(String input) {
        return input.chars()
            .anyMatch(GameValidation::inNotRange);
    }

    private static boolean inNotRange(int codePoint) {
        return START_RANGE > codePoint || codePoint > END_RANGE;
    }

    public static boolean containsDuplication(String input) {
        return input.chars()
            .boxed()
            .collect(Collectors.toSet())
            .size() != GAME_NUMBER_LENGTH;
    }

}
