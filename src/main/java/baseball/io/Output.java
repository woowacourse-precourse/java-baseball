package baseball.io;

import baseball.game.model.BallCount;

public interface Output {

    void print(Message message);

    void print(BallCount ballCount);

    void print(int count);
}
