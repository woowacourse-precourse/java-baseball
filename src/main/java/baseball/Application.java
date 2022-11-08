package baseball;

import static baseball.message.OutputMessage.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        String reGameInput = "";
        
        printGameStartMessage(); //
        do {
            gameManager.playGame();
            printRetryGameMessage();
            reGameInput = gameManager.inputReGameStartNumber();
        } while (gameManager.checkRetryGame(reGameInput));
    }
}