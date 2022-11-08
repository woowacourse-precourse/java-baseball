package baseball;

import static baseball.message.OutputMessage.*;

public class Application {
    public static void main(String[] args) {

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