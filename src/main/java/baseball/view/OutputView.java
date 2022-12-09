package baseball.view;

import baseball.domain.ScoreBoard;

import static baseball.utils.ProgressMessage.*;

public class OutputView {

    public void init() {
        System.out.println(PROGRESS_INIT);
    }

    public void inputNumber() {
        System.out.print(PROGRESS_INPUT_NUMBER);
    }

    public void baseBallResult(ScoreBoard scoreBoard) {
        System.out.println(scoreBoard.toScoreMessage());
    }

    public void endGame() {
        System.out.println(PROGRESS_END_GAME);
    }
}
