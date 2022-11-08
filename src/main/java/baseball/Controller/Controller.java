package baseball.Controller;

import baseball.message.GameMessage;
import baseball.message.InputMessage;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    final int SIZE = 3;
    final int START_NUMBER = 1;
    final int END_NUMBER = 9;
    final int RETRY = 1;
    final int GAME_OVER = 2;

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        gameService.setGame(SIZE, START_NUMBER, END_NUMBER);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        GameMessage.endGameMessage();
    }

    private void askRetry() throws IllegalArgumentException {
        InputMessage.endInputMessage();
        if (getInputNum() == RETRY) {
            run();
        }
    }

    private int getInputNum() throws IllegalArgumentException {
        int inputNum = Integer.parseInt(Console.readLine());

        if (inputNum == 0 || inputNum > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}
