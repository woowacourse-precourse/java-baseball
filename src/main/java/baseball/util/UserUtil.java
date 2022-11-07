package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.status.ControlNumberStatus.START_NUMBER;
import static baseball.status.ControlNumberStatus.END_NUMBER;
import static baseball.status.ControlNumberStatus.DONT_CONTAIN_THIS_NUMBER;
import static baseball.status.NumberStatus.MAX_NUMBER;

public class UserUtil {
    public static String getUserNumberString() {
        String userNumberString = Console.readLine();
        checkUserNumber(userNumberString);
        return userNumberString;
    }

    private static void checkUserNumber(String userNumberString) {
        if (checkNumberLength(userNumberString)) {
            throw new IllegalArgumentException("입력하신 수는 세자리가 아닙니다.");
        }
        if (checkZeroInNumber(userNumberString)) {
            throw new IllegalArgumentException("입력하신 수에 0이 포함됩니다.");
        }
        if (checkOnlyNumber(userNumberString)) {
            throw new IllegalArgumentException("입력하신 수가 자연수로 이루어져있지 않습니다.");
        }
        if (checkOverlapNumber(userNumberString)) {
            throw new IllegalArgumentException("입력하신 수에 중복된 수가 존재함니다.");
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
        if (userNumberString.matches("-?\\d+")) {
            return false;
        }
        return true;
    }

    private static boolean checkZeroInNumber(String userNumberString) {
        if (userNumberString.contains(DONT_CONTAIN_THIS_NUMBER.getText())) {
            return true;
        }
        return false;
    }

    private static boolean checkNumberLength(String userNumberString) {
        if (userNumberString.length() != MAX_NUMBER.getNumber()) {
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
        if (!(userNumberString.equals(START_NUMBER.getText()) || userNumberString.equals(END_NUMBER.getText()))) {
            throw new IllegalArgumentException();
        }
    }
}
