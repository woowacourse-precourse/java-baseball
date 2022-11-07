package baseball.domain;

public class BallCount {

    private static final int MIN_STRIKE_COUNT = 0;
    private static final int MAX_STRIKE_COUNT = 3;
    private static final int MIN_BALL_COUNT = 0;
    private static final int MAX_BALL_COUNT = 3;
    private static final int NO_COUNT = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL_FORMAT = "%s볼";
    private static final String STRIKE_FORMAT = "%s스트라이크";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String BALLCOUNT_FORMAT = "%s는 0에서 3 사이 숫자만 집계합니다";
    private final int Strikes;
    private final int Balls;

    public BallCount(int strikes, int balls) {
        validateStrikeCount(strikes);
        validateBallCount(balls);
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

    private void validateStrikeCount(int strikes) {
        if (strikes < MIN_STRIKE_COUNT || strikes > MAX_STRIKE_COUNT) {
            throw new IllegalArgumentException(String.format(BALLCOUNT_FORMAT, STRIKE));
        }
    }

    private void validateBallCount(int balls) {
        if (balls < MIN_BALL_COUNT || balls > MAX_BALL_COUNT) {
            throw new IllegalArgumentException(String.format(BALLCOUNT_FORMAT, BALL));
        }
    }
}
