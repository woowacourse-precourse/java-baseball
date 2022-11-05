package baseball;

import static baseball.Score.INPUT_LENGTH;
import static baseball.Score.STRIKE_INDEX;

import java.util.List;

public class BaseballGame {
    public static final int RESTART = 1;
    public static final int EXIT = 2;
    private final OutputView outputView = new OutputView();
    public BaseballGame() {
    }

    public void gameStart() {
        while (true) {
            Computer computer = new Computer();
            User user = new User();
            outputView.printGameStart();
            game(computer, user);
            outputView.printRestartOrExit();
            user.inputRestartOrExitNumber();
            if (user.restartOrExitNumber == EXIT) {
                break ;
            }
        }
    }

    public void game(Computer computer, User user) {
        while (true) {
            List<Integer> compareAnswer;

            outputView.printInputHint();
            user.inputGuessRandomNumbers();
            Score score = new Score(user.getInput(), computer.getComputerNumbers());
            compareAnswer = score.getAnswer();
            outputView.printResult(compareAnswer);
            if (compareAnswer.get(STRIKE_INDEX) == INPUT_LENGTH) {
                outputView.printGameEnd(compareAnswer);
                break ;
            }
        }
    }
}
