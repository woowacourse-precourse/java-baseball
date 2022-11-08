package baseball;

import java.util.HashSet;

public class Validator {
    private static final String ALL_NUMBER_REGEX = "\\d+";
    private static final String ALL_IN_RANGE_REGEX =
            String.format("[%d-%d]+", Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END);

    public void checkValidNumberInput(String input) {
        if (!isValidAmount(input)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_AMOUNT.message());
        }
        if (!isAllNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_NUMBER.message());
        }
        if (!isAllInRange(input)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.message());
        }
        if (!isAllDifferent(input)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SAME_NUMBER.message());
        }
    }

    private boolean isValidAmount(String input) {
        return input.length() == Constants.NUMBER_COUNT;
    }

    private boolean isAllNumber(String input) {
        return input.matches(ALL_NUMBER_REGEX);
    }

    private boolean isAllInRange(String input) {
        return input.matches(ALL_IN_RANGE_REGEX);
    }

    private boolean isAllDifferent(String input) {
        HashSet<Character> hs = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!hs.add(c)) {
                return false;
            }
        }

        return true;
    }

    public void checkValidRestartOrQuitInput(String input) {
        if (!input.equals(Constants.RESTART_GAME_CODE) && !input.equals(Constants.QUIT_GAME_CODE)) {
            throw new IllegalArgumentException(ErrorMessage.QUIT_OR_RESTART.message());
        }
    }

    private enum ErrorMessage {
        NUMBER_WRONG_AMOUNT(String.format("%d 자리의 숫자를 입력해주세요.", Constants.NUMBER_COUNT)),
        NUMBER_NOT_NUMBER("숫자만 입력해주세요."),
        NUMBER_NOT_IN_RANGE(String.format("%d-%d 사이의 숫자를 입력해주세요.",
                Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END)),
        NUMBER_SAME_NUMBER("서로 다른 숫자를 입력해주세요."),
        QUIT_OR_RESTART(String.format("%s,%s 중 하나의 수를 입력해주세요.",
                        Constants.RESTART_GAME_CODE, Constants.QUIT_GAME_CODE));

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        private String message() {
            return message;
        }
        }
}
