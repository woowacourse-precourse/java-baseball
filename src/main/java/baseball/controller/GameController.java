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
    private GameStatus gameStatus = GameStatus.GAME_START;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printGameStart();

            while (gameStatus != GameStatus.APPLICATION_EXIT) {
                Computer computer = Computer.createByNumber(Computer.createRandomNumbers());
                System.out.println(computer.getComputerNumber());

                while (gameStatus != GameStatus.GAME_OVER) {
                    Player player = Player.createByNumber(inputView.readPlayerNumber());

                    Referee referee = Referee.judge(computer, player);
                    Result result = referee.judgeBallCount();

                    outputView.printGameResult(result);
                    isThreeStrike = result.isThreeStrike();
                    gameStatus = GameStatus.fromIsThreeStrike(isThreeStrike);
                }
                outputView.printThreeStrike();

                selectedRetry = GameCommand.selectedRetry(inputView.readGameCommand());
                gameStatus = GameStatus.fromSelectedRetry(selectedRetry);
            }

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            throw exception;
        }
    }
}
