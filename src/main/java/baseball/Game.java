package baseball;

import IOController.Screen;
import IOController.User;

public class Game {

    private static final int ENDGAME = 1;
    private static final int PLAYAGAINMODE = 2;

    public Game() {
        Screen.printGameStart();
    }

    public int startAndPlayAgain() {
        Referee.generateRandom();
        progress();
        return checkContinueMode();
    }

    private static void progress() {
        while (true) {
            Screen.printInputNumber();
            String RefereeResult = Screen.printCalculateResult(
                Referee.calculateAnswer(User.inputValue(1)));
            if (RefereeResult.equals("3스트라이크")) {
                break;
            }
        }
    }

    private static int checkContinueMode() {
        Screen.printEndingMessage();
        if (User.inputValue(PLAYAGAINMODE).equals("1")) {
            return PLAYAGAINMODE;
        }
        return ENDGAME;
    }

}
