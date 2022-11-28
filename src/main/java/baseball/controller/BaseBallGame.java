package baseball.controller;

import baseball.domain.GameLogic;
import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseBallGame {
    private Numbers computerNumbers;
    private final static String SUCCESS = "3스트라이크";

    private void initComputerNumbers() {
        computerNumbers = new Numbers();
    }

    public void startGame() {
        boolean play;
        OutputView.printStartMessage();
        do {
            getRandomNumbers();
            play = oneGame();
        } while (play);
    }

    private boolean oneGame() {
        while (true) {
            List<Integer> playerNumbers = getPlayerRandomNumbers();
            GameLogic result = new GameLogic(computerNumbers, playerNumbers);
            OutputView.printResult(result);
            if (result.equals(SUCCESS)) {
                OutputView.printSuccessMessage();
                return InputView.restartOrEndGame();
            }
        }
    }
}
