package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class InputControl {
    private static String readLine() {
        return Console.readLine();
    }
    public static int readInt() {
        return strToInt(readLine());
    }

    public static int strToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
        }
    }
}
