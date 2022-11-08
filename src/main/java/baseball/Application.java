package baseball;

import baseball.controller.GameController;
import baseball.view.SystemMessage;

public class Application {
    public static void main(String[] args) {
        SystemMessage systemMessage = new SystemMessage();
        GameController controller = new GameController();

        systemMessage.showStartMessage();
        controller.startGame();
    }
}
