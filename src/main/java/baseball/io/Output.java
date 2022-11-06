package baseball.io;

import baseball.model.BallStatus;

public interface Output {
    void printStartText();

    void printScore(BallStatus ballStatus);

    void printEndText(BallStatus ballStatus);
}
