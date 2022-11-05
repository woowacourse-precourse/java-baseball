package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private String readLine() {
        return Console.readLine();
    }

    public int readIntWithVerification() {
        String line = readLine();
        InputVerifier.verifyInput(line);
        return Integer.parseInt(line);
    }
}
