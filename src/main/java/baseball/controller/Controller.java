package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.util.Message;
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
        } while (chooseRestartOrNot());
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

    boolean chooseRestartOrNot() {
        OutputView.printRestartOrEnd();
        String input = InputView.inputString();
        if (input.equals(Message.RESTART)) {
            return true;
        }
        if (input.equals(Message.END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
