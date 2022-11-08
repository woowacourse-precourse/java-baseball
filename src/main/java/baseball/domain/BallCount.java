package baseball.domain;

import baseball.util.Validator;

public class BallCount {

    private static final int NO_COUNT = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL_FORMAT = "%s볼";
    private static final String STRIKE_FORMAT = "%s스트라이크";
    private final int strikes;
    private final int balls;

    public BallCount(int strikes, int balls) {
        Validator.validateStrikeCount(strikes);
        Validator.validateBallCount(balls);
        this.strikes = strikes;
        this.balls = balls;
    }

    public String ballCountResult() {
        if (balls == NO_COUNT && strikes == NO_COUNT) {
            return NOTHING;
        }
        if (strikes == NO_COUNT) {
            return String.format(BALL_FORMAT, balls);
        }
        if (balls == NO_COUNT) {
            return String.format(STRIKE_FORMAT, strikes);
        }
        return String.format(BALL_FORMAT, balls) + " " + String.format(STRIKE_FORMAT, strikes);
    }
}
