package baseball.util;

import baseball.status.ControlNumberStatus;
import baseball.status.ExceptionStatus;
import baseball.status.NumberStatus;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserUtil {
    public static String getUserNumberString() {
        String userNumberString = Console.readLine();
        checkUserNumber(userNumberString);
        return userNumberString;
    }

    private static void checkUserNumber(String userNumberString) {
        if (checkNumberLength(userNumberString)) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_CORRECT_LENGTH.getMessage());
        }
        if (checkZeroInNumber(userNumberString)) {
            throw new IllegalArgumentException(ExceptionStatus.ZERO_IN_NUMBER.getMessage());
        }
        if (checkOnlyNumber(userNumberString)) {
            throw new IllegalArgumentException(ExceptionStatus.IS_NOT_NUMBER.getMessage());
        }
        if (checkOverlapNumber(userNumberString)) {
            throw new IllegalArgumentException(ExceptionStatus.IS_OVERLAP.getMessage());
        }

    }

    private static boolean checkOverlapNumber(String userNumberString) {
        Set<String> set = new HashSet<>(Arrays.asList(userNumberString.split("")));
        if (set.size() == userNumberString.length()) {
            return false;
        }
        return true;
    }


    private static boolean checkOnlyNumber(String userNumberString) {
        char[] numberCharList = userNumberString.toCharArray();
        for (int i = NumberStatus.MIN_NUMBER.getNumber(); i < NumberStatus.MAX_NUMBER.getNumber(); i++) {
            if (numberCharList[i] < NumberStatus.ANSWER_MIN_NUMBER_CHAR.getNumber() ||
                    numberCharList[i] > NumberStatus.ANSWER_MAX_NUMBER_CHAR.getNumber()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkZeroInNumber(String userNumberString) {
        if (userNumberString.contains(ControlNumberStatus.DONT_CONTAIN_THIS_NUMBER.getText())) {
            return true;
        }
        return false;
    }

    private static boolean checkNumberLength(String userNumberString) {
        if (userNumberString.length() != NumberStatus.MAX_NUMBER.getNumber()) {
            return true;
        }
        return false;
    }


    public static String getUserInput() {
        String userInput = Console.readLine();
        checkUserInput(userInput);
        return userInput;
    }

    private static void checkUserInput(String userNumberString) {
        if (!(userNumberString.equals(ControlNumberStatus.START_NUMBER.getText()) ||
                userNumberString.equals(ControlNumberStatus.END_NUMBER.getText()))) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_GAME_NUMBER.getMessage());
        }
    }
}
