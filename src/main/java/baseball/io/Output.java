package baseball.io;

import baseball.model.BallCount;

public interface Output {
    void start();

    void ballCount(BallCount bc);
}
