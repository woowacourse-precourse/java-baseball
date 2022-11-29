package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.GameResult;
import baseball.domain.number.BaseballNumbers;
import baseball.domain.number.RandomNumberGenerator;
import baseball.domain.number.NumberGenerator;
import baseball.system.Constant;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.OutputView.Message;
import java.util.List;
import java.util.function.Supplier;

public class GameController {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();
    private BaseballGame baseballGame;

    public void run() {
        OutputView.printMessage(Message.START_GAME);
        setUp();
        do {
            startRound();
            quitOrRestartGame();
        } while (baseballGame.isGameContinue());
    }

    private void setUp() {
        this.baseballGame = new BaseballGame(numberGenerator);
    }

    private void startRound() {
        do {
            BaseballNumbers userBaseballNumbers = getUserNumbers();
            baseballGame.playRound(userBaseballNumbers);
            GameResult gameResult = new GameResult(baseballGame);
            OutputView.printGameStatus(gameResult);
        } while (baseballGame.isGameContinue());
        OutputView.printMessage(Message.GAME_OVER);
    }

    private void quitOrRestartGame() {
        OutputView.printMessage(Message.REQUEST_RESTART_OR_QUIT);
        String number = repeatRequest(InputView::readGameCommand);
        if (number.equals(Constant.GAME_RESTART)) {
            setUp();
        }
    }

    private BaseballNumbers getUserNumbers() {
        try {
            OutputView.printMessage(Message.REQUEST_NUMBER);
            List<Integer> inputNumbers = InputView.readUserNumbers();
            return new BaseballNumbers(inputNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserNumbers();
        }
    }

    private <T> T repeatRequest(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeatRequest(inputReader);
        }
    }
}