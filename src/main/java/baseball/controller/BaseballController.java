package baseball.controller;

import baseball.service.BaseballService;
import baseball.utils.GameOption;
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

    public void play() {
        do {
            outputView.printWithLine(OutputView.GAME_START);
            baseballService.init();
            playGame();
        } while (restartOrFinish());
    }

    public void playGame() {
        do {
            outputView.print(OutputView.INPUT_NUMBER);
            List<Integer> playerNumbers = inputView.inputNumbers();
            outputView.printWithLine(baseballService.checkCounts(playerNumbers));
        } while (!isGameFinished());
    }

    private boolean restartOrFinish() {
        outputView.printWithLine(OutputView.RESTART_OR_EXIT);
        int option = inputView.inputGameOption();
        GameOption gameOption = GameOption.isCorrectOption(option);
        return GameOption.restartOrFinish(gameOption);
    }

    private boolean isGameFinished() {
        if (baseballService.isGameFinished()) {
            outputView.printWithLine(OutputView.GAME_END);
            return true;
        }
        return false;
    }
}
