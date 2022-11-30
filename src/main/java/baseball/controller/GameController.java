package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printGameStart();

            Computer computer = Computer.createByNumber(Computer.createRandomNumbers());
            System.out.println(computer.getComputerNumber());

            while (true) {
                Player player = Player.createByNumber(inputView.readPlayerNumber());

                Referee referee = Referee.judge(computer, player);
                Result result = referee.judgeBallCount();

                outputView.printGameResult(result);

                if (result.isThreeStrike()) {
                    break;
                }
            }

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
