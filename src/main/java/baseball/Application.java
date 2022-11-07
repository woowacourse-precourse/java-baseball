package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {

    	boolean continueGame = true;
    	GameManager gameManager = new GameManager();
    	gameManager.open();
    	
    	while(continueGame) {
    		gameManager.setGame();
    		gameManager.startGame();
    		gameManager.endGame();
    		continueGame = gameManager.confirmRestart();
    	}
    	gameManager.terminateGame();
    	
    	
    }

	
}
