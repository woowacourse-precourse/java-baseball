package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Constant;
import baseball.exception.ComputerException;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private GameService gameService = new GameService();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {

        askUserInputNumberMessage();
        startNumberBaseballGame();
        endNumberBaseballGameMessage();
        askRestartNumberBaseballGame();
    }

    public void askUserInputNumberMessage() {
        inputView.askUserInputNumber();
    }

    public void endNumberBaseballGameMessage() {
        outputView.printMissionCompleteMessage();
    }

    public void startNumberBaseballGame() {
        gameService.startNumberBaseballGame();
    }

    public void askRestartNumberBaseballGame() {
        inputView.askRestartGameMessage();
        String computerOptionNumber = Console.readLine();
        ComputerException computerException = new ComputerException();
        computerException.checkComputerExceptions(computerOptionNumber);

        if (computerOptionNumber.equals(Constant.COMPUTER_GAME_RESTART)) {
            run();
        }
        if (computerOptionNumber.equals(Constant.COMPUTER_GAME_EXIT)) {
            OutputView.printExitMessage();
        }
    }


}