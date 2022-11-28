package baseball.controller;

import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGame {
    private Numbers computerNumbers;
    private final static String SUCCESS = "3스트라이크";

    private void initComputerNumbers() {
        computerNumbers = new Numbers();
    }

    public void gameStart() {
        do {
            initComputerNumbers();
            oneGame();
        } while (retry());
    }

    private void oneGame() {
        GameResult result;
        do {
            Numbers playerNumbers = InputView.readNumbers();
            result = playerNumbers.compareToNumbers(computerNumbers);
            result.showResult();
        } while (!result.isSuccess());
        OutputView.printSuccessMessage();
    }

    private boolean retry() {
        return Objects.equals(InputView.readRetry(), "1");
    }
}
