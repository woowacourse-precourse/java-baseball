package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getGuessedAnswer() {
        return Console.readLine();
    }

    public static String getRestartOrStopCommand() {
        return Console.readLine();
    }
}
