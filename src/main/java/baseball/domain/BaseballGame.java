package baseball.domain;

import baseball.util.Input;
import baseball.util.View;
import java.util.List;

public class BaseballGame {
    private final Computer computer;
    private boolean isFinish = false;

    public BaseballGame() {
        this.computer = new Computer();
    }

    public BaseballGame(List<Integer> computerNumbers) {
        this.computer = new Computer(computerNumbers);
    }

    public void play() {
        View.printGameStart();
        do {
            View.printRequestPlayerGuess();
            Hint hint = computer.createHint(Input.inputPlayerNumber());
            View.printHint(hint);
            checkCorrect(hint);
        } while (!isFinish);
        View.printGameFinish();
    }

    private void checkCorrect(Hint hint) {
        if (hint.isFullStrikes()) {
            this.isFinish = true;
        }
    }
}
