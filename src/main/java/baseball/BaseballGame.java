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
            outputView.printGameStart();
            Computer computer = new Computer();
            game(computer);

        }
    }

    public void game(Computer computer) {
        while (true) {
            List<Integer> compareAnswer;

            outputView.printInputHint();
            User user = new User();
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
