package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readString() {
        String inputString;
        inputString = Console.readLine();
        return inputString;
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

}
