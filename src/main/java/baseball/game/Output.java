package baseball.game;

import static baseball.constant.SystemMessage.ENTER_NUMBER;
import static baseball.constant.SystemMessage.RESTART_GAME_OR_END;
import static baseball.constant.SystemMessage.START_NUMBER_BASEBALL_GAME;

public class Output {

    public void printWelcomeMessage() {
        System.out.println(START_NUMBER_BASEBALL_GAME);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_GAME_OR_END);
    }

    public void printEnterNumberMessage() {
        System.out.print(ENTER_NUMBER);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
