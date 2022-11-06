package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.util.ErrorMessage;
import baseball.util.Message;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    Computer computer;
    Player player;
    GameResult gameResult;

    public void startGame() {
        OutputView.printGameStart();
        do {
            playOneGame();
        } while (chooseRestartOrEnd());
    }

    void playOneGame() {
        computer.pickRandomNumbers();
        do {
            player.guessNumbers();
            gameResult.calculate(computer, player);
            OutputView.printResult(gameResult.toString());
        } while (!gameResult.isAllStrike());
        OutputView.printGameEnd();
    }

    boolean chooseRestartOrEnd() {
        OutputView.printRestartOrEnd();
        String input = InputView.inputString();
        if (input.equals(Message.RESTART)) {
            return true;
        }
        if (input.equals(Message.END)) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
    }
}
