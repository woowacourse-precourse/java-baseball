package baseball.domain;

import static baseball.constant.Constants.*;

public class Result {
    private final int ballCount;
    private final int strikeCount;

    public Result(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNotOver() {
        return strikeCount != MAX_STRIKE;
    }

    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        } else if(ballCount == 0) {
            return strikeCount + STRIKE;
        } else if(strikeCount == 0) {
            return ballCount + BALL;
        }
        return ballCount + BALL + strikeCount + STRIKE;
    }
}
