package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(getGuideMessage(null));
        while (true) {
            String userNumber = getUserNumber();
        }

    }

    public static String getGuideMessage(String userNumber) {
        if (userNumber == null) {
            return "숫자 야구 게임을 시작합니다.";
        } else {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        }
    }

    public static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static boolean checkNumberLength(String userNumber) {
        return userNumber.length() == 3;
    }

    public static boolean checkOnlyNumber(String userNumber) {
        try {
            Double.parseDouble(userNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkNotContainZero(String userNumber) {
        return !userNumber.contains("0");
    }

    public static boolean checkNotDuplication(String userNumber) {
        for (int index = 0; index < userNumber.length(); index++) {
            if (userNumber.indexOf(userNumber.charAt(index)) != index) {
                return false;
            }
        }
        return true;
    }

    public static void checkIllegalArgumentException(String userNumber) {
        if (!checkNumberLength(userNumber)) {
            throw new IllegalArgumentException("입력이 세 자리 수가 아닙니다!");
        }
        if (!checkOnlyNumber(userNumber)) {
            throw new IllegalArgumentException("입력이 숫자로만 이루어지지 않았습니다!");
        }
        if (!checkNotContainZero(userNumber)) {
            throw new IllegalArgumentException("입력에 0이 포함되어 있습니다!");
        }
        if (!checkNotDuplication(userNumber)) {
            throw new IllegalArgumentException("입력에 같은 수가 중복되었습니다!");
        }

    }

    public static String convertArrayListToString(List<Integer> numberList) {
        StringBuilder sb = new StringBuilder();
        for (int number: numberList) {
            sb.append(number);
        }
        return sb.toString();
    }

}
