package baseball.controller;

import baseball.domain.GameLogic;
import baseball.domain.RandomNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.view.InputView.getPlayerRandomNumbers;

public class BaseBallGame {
    private RandomNumbers computerNumbers;
    private final static String SUCCESS = "3스트라이크";

    private void getRandomNumbers() {
        computerNumbers = new RandomNumbers();
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
