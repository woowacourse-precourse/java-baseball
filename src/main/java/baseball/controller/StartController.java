package baseball.controller;

import baseball.domain.Again;
import baseball.domain.Computer;
import baseball.view.StartEndGameView;

public class StartController {
    private static final int EXIT_CODE = 2;
    final StartEndGameView startEndGameView;

    public StartController() {
        this.startEndGameView = new StartEndGameView();
        startEndGameView.startGamePrint();
    }

    public void run() {
        do {
            startGame();
        } while(askOneMore() != EXIT_CODE);
    }

    public void startGame() {
        Computer computer = new Computer();
        GameController gameController = new GameController();
        gameController.playGame(computer);
    }

    public int askOneMore() {
        startEndGameView.successGamePrint();
        Again again = new Again(startEndGameView.inputToQuestion());
        if (again.getDoTry() == EXIT_CODE) {
            startEndGameView.endGamePrint();
        }
        return again.getDoTry();
    }
}
