package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.GameStatus;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private boolean selectedRetry = true;
    private boolean isThreeStrike;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printGameStart();

            while (selectedRetry) {
                Computer computer = Computer.createByNumber(Computer.createRandomNumbers());
                System.out.println(computer.getComputerNumber());

                while (!isThreeStrike) {
                    Player player = Player.createByNumber(inputView.readPlayerNumber());

                    Referee referee = Referee.judge(computer, player);
                    Result result = referee.judgeBallCount();

                    outputView.printGameResult(result);
                    isThreeStrike = result.isThreeStrike();
                }
                outputView.printThreeStrike();
                selectedRetry = GameCommand.selectedRetry(inputView.readGameCommand());
                if(selectedRetry) {
                    isThreeStrike = false;
                }
            }

    } catch(
    IllegalArgumentException exception)

    {
        outputView.printExceptionMessage(exception);
        throw exception;
    }
}
}
