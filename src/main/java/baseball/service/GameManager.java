package baseball.service;

import baseball.domain.Computer;
import baseball.status.Comments;
import baseball.utils.ConsoleUtil;

public class GameManager {

    private boolean gameContinue = true;

    public void run() {
        ConsoleUtil.consoleOutputLine(Comments.GAME_INITIALIZE.getComment());

        while (gameContinue) {
            Computer computer = new Computer();
        }
    }
}
