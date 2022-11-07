package baseball.domain;

import baseball.util.Validator;

public class BallCount {

    private static final int NO_COUNT = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL_FORMAT = "%s볼";
    private static final String STRIKE_FORMAT = "%s스트라이크";
    private final int Strikes;
    private final int Balls;

    public BallCount(int strikes, int balls) {
        Validator.validateStrikeCount(strikes);
        Validator.validateBallCount(balls);
        Strikes = strikes;
        Balls = balls;
    }

    public String ballCountResult() {
        if (Balls == NO_COUNT && Strikes == NO_COUNT) {
            return NOTHING;
        }
        if (Strikes == NO_COUNT) {
            return String.format(BALL_FORMAT, Balls);
        }
        if (Balls == NO_COUNT) {
            return String.format(STRIKE_FORMAT, Strikes);
        }
        return String.format(BALL_FORMAT, Balls) + " " + String.format(STRIKE_FORMAT, Strikes);
    }
}
