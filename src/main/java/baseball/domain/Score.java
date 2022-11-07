package baseball.domain;

import static baseball.domain.CountStatus.BALL_AND_STRIKE;
import static baseball.domain.CountStatus.NOTHING;
import static baseball.domain.CountStatus.ONLY_BALL;
import static baseball.domain.CountStatus.ONLY_STRIKE;
import static baseball.utils.Constants.CORRECT_STRIKE_COUNT;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final int strike;
    private final int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public CountStatus getCountStatus() {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        if (strike >= 0 && ball == 0) {
            return ONLY_STRIKE;
        }
        if (strike == 0 && ball >= 0) {
            return ONLY_BALL;
        }
        return BALL_AND_STRIKE;
    }

    public List<Integer> getStrikeAndBallCount(CountStatus countStatus) {
        if (countStatus == NOTHING) {
            return new ArrayList<>();
        }
        if (countStatus == ONLY_STRIKE) {
            return List.of(strike);
        }
        if (countStatus == ONLY_BALL) {
            return List.of(ball);
        }
        return List.of(ball, strike);
    }

    public boolean isCorrect() {
        return strike == CORRECT_STRIKE_COUNT;
    }
}
