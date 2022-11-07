package baseball.view;

import baseball.verifier.ControlNumberVerifier;
import baseball.verifier.GameVerifier;
import baseball.verifier.Verifier;
import camp.nextstep.edu.missionutils.Console;

public final class InputHandler {
    public int readGameInput() {
        String line = readLine();
        GameVerifier.check(line);
        return Integer.parseInt(line);
    }

    public int readGameControlInput() {
        String line = readLine();
        Verifier controlVerifier = new ControlNumberVerifier();
        controlVerifier.check(line);
        return Integer.parseInt(line);
    }

    private String readLine() {
        return Console.readLine();
    }
}
