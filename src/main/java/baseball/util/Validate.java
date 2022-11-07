package baseball.util;

import baseball.message.ExceptionMessage;

import java.util.HashSet;
import java.util.Set;

import static baseball.util.ProcessCode.FINISH;
import static baseball.util.ProcessCode.RESTART;

public class Validate {

    public static void inputValidate(String input) {
        numberOnly(input);
        ruleDigit(input);
        containZero(input);
        differentDigits(input);
    }

    private static void numberOnly(String input) {
        for (int indexOfDigit = 0; indexOfDigit < input.length(); indexOfDigit++) {
            if (!Character.isDigit(input.charAt(indexOfDigit))) {
                throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMBER);
            }
        }
    }

    private static void ruleDigit(String input) {
        if (input.length() != GameRule.NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_LENGTH);
        }
    }

    private static void containZero(String digits) {
        for (int indexOfDigits = 0; indexOfDigits < digits.length(); indexOfDigits++) {
            char digit = digits.charAt(indexOfDigits);

            if (digit == '0') {
                throw new IllegalArgumentException(ExceptionMessage.IS_ZERO);
            }

        }

    }

    private static void differentDigits(String digits) {
        Set<Character> countOfNumbers = new HashSet<>();
        for (int indexOfDigits = 0; indexOfDigits < digits.length(); indexOfDigits++) {
            char digit = digits.charAt(indexOfDigits);

            if (countOfNumbers.contains(digit)) {
                throw new IllegalArgumentException(ExceptionMessage.IS_DUPLICATE_DIGIT);
            }

            countOfNumbers.add(digit);

        }
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
