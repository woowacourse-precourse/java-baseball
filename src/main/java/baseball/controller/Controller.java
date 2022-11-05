package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    Computer computer;
    Player player;

    public Controller() {
        computer = new Computer();
        player = new Player();
    }

    public void startGame() {
        OutputView.printGameStart();
        do {
            playOneGame();
        } while (!chooseEndOrNot());
    }

    void playOneGame() {
        computer.pickRandomNumbers();
        GameResult gameResult;
        do {
            player.guessNumbers();
            gameResult = new GameResult(computer, player);
            OutputView.printResult(gameResult.toString());
        } while (gameResult.getStrike() != 3);
    }

    boolean chooseEndOrNot() {
        OutputView.printEndOrNot();
        String input = InputView.inputString();
        if (input.equals("1")) {
            return false;
        }
        if (input.equals("2")) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
