package baseball.view;

import baseball.verifier.GameVerifier;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private String readLine() {
        return Console.readLine();
    }

    public int readIntWithVerification() {
        String line = readLine();
        GameVerifier.check(line);
        return Integer.parseInt(line);
    }
}
