package baseball.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class Input {
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String get() {
        System.out.print(inputMessage);
        String number = Console.readLine();
        if (!isValid(number)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static boolean isValid(String number) {
        if (number.length() != 3) {
            return false;
        }
        HashSet<Character> set = new HashSet<Character>();
        for (char c : number.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
            if(c == '0') {
                return false;
            }
            if(!set.isEmpty() && set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static String restart() {
        System.out.println(restartMessage);
        String number = Console.readLine();
        if (!isValidRestartNumber(number)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    private static boolean isValidRestartNumber(String number) {
        if (number.equals("1") || number.equals("2")) {
            return true;
        }
        return false;
    }
}
