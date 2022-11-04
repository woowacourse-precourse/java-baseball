package baseball.domain;

import baseball.util.Input;

public class BaseballGame {
    private final Computer computer = new Computer();
    private boolean isFinish = false;

    public BaseballGame() {}

    public void play() {
        do {
            String playerGuess = Input.inputPlayerNumber();
            Hint hint = computer.createHint(playerGuess);
            checkCorrect(hint);
        } while (!isFinish);
    }

    private void checkCorrect(Hint hint) {
        if (hint.isFullStrikes()) {
            this.isFinish = true;
        }
    }
}
