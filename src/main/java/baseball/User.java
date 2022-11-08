package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {


    public static List<Integer> getUserNumber() {
        System.out.println("숫자를 입력해 주세요 : ");
        String number = Console.readLine();
        userCheckException(number);
        return getReturn(number);
    }

    public static List<Integer> getReturn(String number) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            answer.add(Character.getNumericValue(number.charAt(i)));
        }
        return answer;
    }

    public static void userCheckException(String number) {
        if (userNumberCheck(number)) {
            return;
        }
        throw new IllegalArgumentException();
    }
    public static boolean userNumberCheck(String result) {
        if (result.length() != 3) {
            return false;
        }

        for (int i = 0; i < result.length(); i++) {
            if (!Character.isDigit(result.charAt(i))) {
                return false;
            }
        }

        Set<Character> in = new HashSet<>();
        for (int i = 0; i < result.length(); i++) {
            in.add(result.charAt(i));
        }
        if (in.size() != result.length()) {
            return false;
        }

        for (int i = 0; i < result.length(); i++) {
            if ('0' == result.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
