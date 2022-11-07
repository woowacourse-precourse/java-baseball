package baseball.util;

import baseball.message.ExceptionMessage;

import java.util.HashSet;
import java.util.Set;

import static baseball.util.ProcessCode.FINISH;
import static baseball.util.ProcessCode.RESTART;

public class Validate {

    public static boolean isRuleDigit(String input) {
        if (input.length() == GameRule.NUMBER_OF_NUMBERS) {
            return true;
        }
        throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_LENGTH);
    }

    public static boolean isDifferentDigits(String digits) {
        Set<Character> countOfNumbers = new HashSet<>();
        for (int indexOfDigits = 0; indexOfDigits < digits.length(); indexOfDigits++) {
            char digit = digits.charAt(indexOfDigits);

            if (countOfNumbers.contains(digit)) {
                return false;
            }

            countOfNumbers.add(digit);

        }
        return true;
    }

    public static boolean isNotContainZero(String digits) {
        for (int indexOfDigits = 0; indexOfDigits < digits.length(); indexOfDigits++) {
            char digit = digits.charAt(indexOfDigits);

            if (digit == '0') {
                return false;
            }

        }
        return true;
    }

    public static boolean isAcceptAbleEndGame(String userInput) {
        if (isReStartGame(userInput) || isFinishGame(userInput)) {
            return true;
        }
        throw new IllegalArgumentException(ExceptionMessage.IS_NOT_ONE_AND_TWO);
    }

    public static boolean isReStartGame(String userInput) {
        return userInput.equals(RESTART.getValue());
    }

    private static boolean isFinishGame(String userInput) {
        return userInput.equals(FINISH.getValue());
    }
}
