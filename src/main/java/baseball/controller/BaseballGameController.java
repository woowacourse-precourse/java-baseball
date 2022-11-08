package baseball.controller;

import baseball.domain.BaseballGameMachine;
import baseball.domain.BaseballGameResult;
import baseball.domain.BaseballGameStatus;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private static final InputView inputView = InputView.INSTANCE;
    private static final OutputView outputView = OutputView.INSTANCE;

    private final BaseballNumbersFactory baseballNumberFactory;
    private final BaseballGameMachine baseballGameMachine;

    public BaseballGameController(BaseballNumbersFactory baseballNumberFactory,
                                  BaseballGameMachine baseballGameMachine) {
        this.baseballNumberFactory = baseballNumberFactory;
        this.baseballGameMachine = baseballGameMachine;
        this.baseballGameMachine.initialize(baseballNumberFactory.generate());
    }

    public void run() {
        outputView.printGameStart();

        while (baseballGameMachine.isGameContinues()) {
            String playerInput = inputView.inputBaseballNumber();
            BaseballNumbers playerBaseballNumbers = baseballNumberFactory.generate(playerInput);
            BaseballGameResult baseballGameResult = baseballGameMachine.play(playerBaseballNumbers);
            outputView.printGameResult(baseballGameResult);

            checkGameEnd();
        }
    }

    private void checkGameEnd() {
        if (baseballGameMachine.isGameContinues()) {
            return;
        }

        outputView.printGameEnd();
        BaseballGameStatus baseballGameStatus = inputView.inputGameStatus();
        if (baseballGameStatus.isGameContinues()) {
            baseballGameMachine.initialize(baseballNumberFactory.generate());
        }
    }
}
