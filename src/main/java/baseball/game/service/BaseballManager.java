package baseball.game.service;

import baseball.game.common.Constants;
import baseball.game.io.BaseballGameInput;
import baseball.game.io.BaseballGameOutput;

import java.util.List;

public class BaseballManager {

    public static void startGame() {
        BaseballGameOutput.printGameStart();
        while (true) {
            List<Integer> computerNumber = ComputerNumber.generate();
            InningManager.play(computerNumber);
            if (!isRegame(BaseballGameInput.getRegameStatus())) {
                break;
            }
        }
    }

    public static boolean isRegame(String rematch) {
        if (rematch.equals(Constants.RE_GAME)) {
            return true;
        }

        if (rematch.equals(Constants.END_GAME)) {
            return false;
        }

        throw new IllegalArgumentException();
    }


}
