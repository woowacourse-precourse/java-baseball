package baseball;

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
        }
    }
}
