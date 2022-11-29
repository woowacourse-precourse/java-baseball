package baseball.controller;

import baseball.model.BallCount;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

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

            Player player = Player.createByNumber(inputView.readPlayerNumber());

            Referee referee = Referee.judge(computer, player);
            Map<BallCount, Integer> ballCount = referee.getBallCountJudgement();

            System.out.println(ballCount);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
