package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import static baseball.util.InputValidator.validatePlayerNumber;
import static baseball.util.InputValidator.validateRestartFlag;

public class Input {

    public static String inputRestartFlag() throws IllegalArgumentException {
        String restartFlag = Console.readLine();
        validateRestartFlag(restartFlag);

        return restartFlag;
    }

    public static String inputPlayerNumber() throws IllegalArgumentException {
        String playerNumber = Console.readLine();
        validatePlayerNumber(playerNumber);

        return playerNumber;
    }
}
