package controller;

import baseball.BaseballGame;
import baseball.ComputerNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseballGameController {
    public void start() {
        OutputView.printStartMessage();
        startProgress();
    }

    private void startProgress() {
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.generateComputerNumbers(new ComputerNumberGenerator());
            tryGame(baseballGame);
        } while (willRetry());
    }

    private void tryGame(BaseballGame baseballGame) {
        do {
            String playerNumbers = getPlayerNumbers();
            printResult(baseballGame.getResult(playerNumbers));
        } while (!baseballGame.isWin());
    }

    private boolean willRetry() {
        OutputView.printReadGameCommand();
        return InputView.getGameCommand().equals("1");
    }

    private void printResult(String result) {
        OutputView.printResult(result);
    }

    private String getPlayerNumbers() {
        OutputView.printReadPlayerNumbers();
        return InputView.getGamePlayerInput();
    }
}
