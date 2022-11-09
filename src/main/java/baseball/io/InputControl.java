package baseball.io;

import baseball.enums.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputControl {


    public static int readInt() {
        return strToInt(readLine());
    }

    public static int strToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.value());
        }
    }

    private static String readLine() {
        return Console.readLine();
    }
}
