package baseball.view;

import baseball.verifier.BaseballNumVerifier;
import baseball.verifier.ControlNumberVerifier;
import baseball.verifier.Verifier;
import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    public int readGameInput() {
        String line = Console.readLine();

        Verifier baseballNumVerifier = new BaseballNumVerifier();
        baseballNumVerifier.check(line);
        return Integer.parseInt(line);
    }

    public int readGameControlInput() {
        String line = Console.readLine();

        Verifier controlVerifier = new ControlNumberVerifier();
        controlVerifier.check(line);
        return Integer.parseInt(line);
    }
}
