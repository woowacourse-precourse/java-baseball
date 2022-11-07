package baseball.domain;

import java.util.stream.Collectors;

public class BaseballGuide {

    public final static int NUMBER_LENGTH = 3;
    public final static int RANGE_START = 1;
    public final static int RANGE_END = 9;

    private BaseballGuide() {
    }

    static class Validator {

        private Validator() {
        }

        public static void validate(String input) {
            if (isInvalidLength(input)) {
                throw new IllegalArgumentException(
                    NUMBER_LENGTH + "자리 입력이 필요합니다. 입력 길이: " + input.length());
            }

            if (containsNotDigit(input)) {
                throw new IllegalArgumentException(
                    "숫자가 아닌 문자가 포함되어 있습니다. 입력: " + input);
            }

            if (containsInvalidRangeDigit(input)) {
                throw new IllegalArgumentException(
                    RANGE_START + "~" + RANGE_END + " 범위를 벗어난 숫자가 포함되어 있습니다. 입력: " + input);
            }

            if (containsDuplication(input)) {
                throw new IllegalArgumentException(
                    "중복되는 숫자가 포함되어 있습니다. 입력: " + input);
            }
        }

        private static boolean isInvalidLength(String input) {
            return input.length() != NUMBER_LENGTH;
        }

        private static boolean containsNotDigit(String input) {
            return input.chars()
                .anyMatch(Validator::isNotDigit);
        }

        private static boolean isNotDigit(int codePoint) {
            return !Character.isDigit(codePoint);
        }

        private static boolean containsInvalidRangeDigit(String input) {
            return input.chars()
                .map(Character::getNumericValue)
                .anyMatch(Validator::inNotRange);
        }

        private static boolean inNotRange(int number) {
            return RANGE_START > number || number > RANGE_END;
        }

        private static boolean containsDuplication(String input) {
            return input.chars()
                .boxed()
                .collect(Collectors.toSet())
                .size() != NUMBER_LENGTH;
        }
    }

}
