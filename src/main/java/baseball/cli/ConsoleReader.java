package baseball.cli;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {
    public static String readString() {
        return Console.readLine();
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }
}
