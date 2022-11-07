package baseball.util;

import baseball.status.ControlNumberStatus;
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
        if (!(userNumberString.equals(ControlNumberStatus.START_NUMBER.getText()) || userNumberString.equals(ControlNumberStatus.END_NUMBER.getText()))) {
            throw new IllegalArgumentException();
        }
    }
}
