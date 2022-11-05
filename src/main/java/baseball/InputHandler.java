package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private String readLine() {
        return Console.readLine();
    }

    public int readInt() {
        return Integer.parseInt(readLine());
    }
}
