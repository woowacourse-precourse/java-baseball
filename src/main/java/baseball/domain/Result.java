package baseball.domain;

import static baseball.Constants.EXIT;
import static baseball.Constants.START;

public class Result {

    private Ball ball;
    private Strike strike;

    public Result(Ball ball, Strike strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBallCount() {
        return this.ball.getCount();
    }

    public int getStrikeCount() {
        return this.strike.getCount();
    }

    public int isRoundFinish() {
        if (ball.isZERO() && strike.isAllStrike()) {
            return EXIT;
        }

        return START;
    }
}
