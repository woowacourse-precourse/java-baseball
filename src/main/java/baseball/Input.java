package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        checkLength(inputStr);
        checkNumber(inputStr);
        return inputStr;
    }

    public static void checkLength(String inputStr) {
        if (inputStr.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력하세요.");
        }
    }

    public static void checkNumber(String inputStr) {
        if ( (inputStr.charAt(0) == inputStr.charAt(1))
                || (inputStr.charAt(1) == inputStr.charAt(2))
                ||(inputStr.charAt(0) == inputStr.charAt(2))
        ) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력하세요.");
        }
    }
}
