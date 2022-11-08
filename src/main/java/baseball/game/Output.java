package baseball.game;

import baseball.constant.SystemMessage;

public class Output {

    public void printWelcomeMessage() {
        System.out.println(SystemMessage.START_NUMBER_BASEBALL_GAME);
    }

    public void printRestartMessage() {
        System.out.println(SystemMessage.RESTART_GAME_OR_END);
    }

    public void printEnterNumberMessage() {
        System.out.print(SystemMessage.ENTER_NUMBER);
    }

    public void printResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }
}
