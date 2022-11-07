package baseball;

import java.util.InputMismatchException;

public class Game {
    private boolean gameStatus;
    private final String ERRORMESSAGE = "1과 2중 하나만 입력하세요";

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public void isGameRestart(String playerInput) {
        try {
            int inputNum = Integer.parseInt(playerInput);
            if (inputNum == 1) {
                this.startGame();
                return;
            }
            if(inputNum == 2) {
                endGame();
                return;
            }
            throw new InputMismatchException(ERRORMESSAGE);

        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERRORMESSAGE);
        }
    }

    public void startGame() {
        this.gameStatus = true;
    }

    public void endGame() {
        this.gameStatus = false;
    }

    public boolean isValidInput(String playerInput) {

    }
}
