package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateAnswer() {
        String answer = "";

        while(answer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains((char)randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public static String convertIntToString(int intValue) {
        return String.valueOf(intValue);
    }

    public static boolean isValidInput(String input) {
        if(isOnlyNumber(input) && isThreeDigit(input) && isAllDifferent(input)) {
            return false;
        }
        return true;
    }

    public static boolean isOnlyNumber(String input) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            return false;
        }
        return true;
    }

    public static boolean isThreeDigit(String input) {
        if(input.length() != 3) {
            return false;
        }
        return true;
    }

    public static boolean isAllDifferent(String input) {
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        if(first == second || second == third || first == third) {
            return false;
        }
        return true;
    }
}
