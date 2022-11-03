package baseball;

import static baseball.Compare.INPUT_LENGTH;
import static baseball.Compare.STRIKE_INDEX;

import java.util.List;

public class BaseballGame {
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
            if (user.restartOrExitNumber == 1) {
                break ;
            }
        }
    }

    public void game(Computer computer, User user) {
        while (true) {
            List<Integer> compareAnswer;

            outputView.printInputHint();
            user.inputGuessRandomNumbers();
            Compare compare = new Compare(user.getInput(), computer.getComputerNumbers());
            compareAnswer = compare.getAnswer();
            outputView.printResult(compareAnswer);
            if (compareAnswer.get(STRIKE_INDEX) == INPUT_LENGTH) {
                outputView.printGameEnd(compareAnswer);
                break ;
            }
        }
    }
}
