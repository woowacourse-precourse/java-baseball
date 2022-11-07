package baseball;

import baseball.Constants.EndCommand;

/**
 * 각각의 상황에 입력이 올바른지 확인해주는 메서드를 제공하는 클래스입니다.
 */
public class InputChecker {

    private static boolean hasLengthOf(String input, int length) {
        return input.length() == length;
    }

    private static boolean hasDigitsOnly(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    public static void isGuessCommandValid(String input, int length) {
        if (!hasDigitsOnly(input) || !hasLengthOf(input, length)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isEndCommandValid(String input) {
        if (EndCommand.find(input) == EndCommand.UNKNOWN) {
            throw new IllegalArgumentException();
        }
    }
}
