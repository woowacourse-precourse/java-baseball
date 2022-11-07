package baseball.problemmaker;

import baseball.Numbers;
import baseball.dto.BallCount;

public interface ProblemMaker {

    BallCount findBallCount(Numbers numbers);

    void printHintOfBallCount(BallCount ballCount);

    boolean isFinishedCurrentGame(BallCount ballCount);
}
