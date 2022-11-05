package baseball.domain;

import baseball.util.Input;
import baseball.util.View;

public class BaseballGame {
    private final Computer computer = new Computer();
    private boolean isFinish = false;

    public BaseballGame() {}

    public void play() {
        do {
            View.printGameStart();
            View.printRequestPlayerGuess();
            Hint hint = computer.createHint(Input.inputPlayerNumber());
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
