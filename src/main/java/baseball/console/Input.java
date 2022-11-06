package baseball.console;

import java.util.HashSet;
import java.util.Scanner;

public class Input {
    private static final String inputMessage = "숫자를 입력해주세요 : ";

    public static String get() {
        System.out.print(inputMessage);
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
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
}
