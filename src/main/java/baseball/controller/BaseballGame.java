package baseball.controller;

import static baseball.model.Score.INPUT_LENGTH;
import static baseball.model.Score.STRIKE_INDEX;

import baseball.model.Computer;
import baseball.view.OutputView;
import baseball.model.Score;
import baseball.model.User;
import java.util.List;

public class BaseballGame {
    public static final int RESTART = 1;
    public static final int EXIT = 2;
    private final OutputView outputView = new OutputView();
    private Computer computer;
    private User user;
    public BaseballGame() {
            this.computer = new Computer();
            this.user = new User();
            outputView.printGameStart();
    }

    public void game() {
        while (true) {
            this.computer.randomNumberGenerate();
            whileUserInputCorrectAnswer();
            outputView.printRestartOrExit();
            this.user.inputRestartOrExitNumber();
            if (this.user.getRestartOrExitNumber() == EXIT) {
                break ;
            }
        }
    }

    public void whileUserInputCorrectAnswer() {
        while (true) {
            List<Integer> compareAnswer;
            outputView.printInputHint();
            this.user.inputGuessRandomNumbers();
            Score score = new Score(this.user.getInput(), this.computer.getComputerNumbers());
            compareAnswer = score.getScore();
            outputView.printResult(compareAnswer);
            if (compareAnswer.get(STRIKE_INDEX) == INPUT_LENGTH) {
                outputView.printGameEnd(compareAnswer);
                break ;
            }
        }
    }
}
