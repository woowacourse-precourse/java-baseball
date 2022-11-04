package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getGuessedAnswer() {
        String guessedAnswer = Console.readLine();
        return guessedAnswer;
    }

    public static String getRestartOrStopCommand() {
        String restartOrStopCommand = Console.readLine();
        return restartOrStopCommand;
    }
}
