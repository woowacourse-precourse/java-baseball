package baseball.controller;

import baseball.service.BaseBallService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BaseBallService baseBallService = new BaseBallService();

    public void gameStart() {
        initGame();
        do {
            inProgress();
        } while (restart());
    }

    public boolean restart() {
        String choice = inputView.controllGame();
        validateRestart(choice);

        boolean startFlag = true;

        if (choice.equals("1")) {
            baseBallService.resetGame();
        }

        if (choice.equals("2")) {
            startFlag = false;
        }

        return startFlag;
    }

    public void inProgress() throws IllegalArgumentException {
        while (!baseBallService.isWinGame()) {
            String userNumber = inputView.inputNumber();
            baseBallService.userInputSave(userNumber);
            baseBallService.saveResult();

            if (baseBallService.isNotting()) {
                outputView.printNothing();
                continue;
            }

            if (baseBallService.isWinGame()) {
                outputView.printWinGame(baseBallService.getStrike());
                break;
            }

            outputView.printResult(baseBallService.getStrike(), baseBallService.getBall());

        }
    }

    public void initGame() {
        outputView.printInitGameMessage();
        baseBallService.initGame();
    }

    public void validateRestart(String choice) throws IllegalArgumentException {
        if (!choice.equals("1") && !choice.equals("2")) {
            throw new IllegalArgumentException("입력은 1 또는 2만 가능합니다.");
        }
    }
}
