package baseball.io;

import baseball.game.model.BallCount;

public interface Output {

    void print(Message message);

    void printBallCount(BallCount ballCount);

    void printEndMessage(int count);
}
