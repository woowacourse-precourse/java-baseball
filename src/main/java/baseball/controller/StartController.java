package baseball.controller;

import baseball.domain.Again;
import baseball.domain.Computer;
import baseball.view.StartEndGameView;

public class StartController {
    final StartEndGameView startEndGameView;

    public StartController() {
        this.startEndGameView = new StartEndGameView();;
        startEndGameView.startGamePrint();
    }

    public void startGame() {
        Computer computer = new Computer();
        GameController gameController = new GameController();
        gameController.playGame(computer);
    }

    public int askOneMore() {
        startEndGameView.endGamePrint();
        Again again = new Again(startEndGameView.inputToQuestion());
        return again.getDoTry();
    }
}
