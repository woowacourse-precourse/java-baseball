
package baseball.controller;

import baseball.rule.GameOption;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {

    private static final InputView inputView = new InputView();

    private static final OutputView outputView = new OutputView();

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void init() {
        do {
            outputView.printWithLine(OutputView.START_GAME);
            baseballService.init();
            playGame();
        } while (playOrStop());
    }

    public void playGame() {
        do {
            outputView.print(OutputView.INPUT_NUMBERS);
            List<Integer> inputNumbers = inputView.inputNumbers();
            outputView.printWithLine(baseballService.checkCounts(inputNumbers));
        } while (!isGameOver());
    }

    private boolean playOrStop() {
        outputView.printWithLine(OutputView.PLAY_OR_NOT);
        int option = inputView.inputNumber();
        GameOption gameOption = GameOption.isCorrectOption(option);
        return GameOption.playOrStop(gameOption);
    }

    private boolean isGameOver() {
        if (baseballService.isGameOver()) {
            outputView.printWithLine(OutputView.END_GAME);
            return true;
        }
        return false;
    }
}