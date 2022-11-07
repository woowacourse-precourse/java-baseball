package baseball.domain;

public class BallCount {

    private final int MIN_STRIKE_COUNT = 0;
    private final int MAX_STRIKE_COUNT = 3;
    private final int MIN_BALL_COUNT = 0;
    private final int MAX_BALL_COUNT = 3;

    private final int NO_COUNT = 0 ;
    private int Strikes;
    private int Balls;

    public BallCount(int strikes, int balls) {
        validateStrikeCount(strikes);
        validateBallCount(balls);
        Strikes = strikes;
        Balls = balls;
    }

    public String ballCountResult() {
        if (Balls == NO_COUNT && Strikes == NO_COUNT) {
            return "낫싱";
        }
        if (Strikes == NO_COUNT) {
            return String.valueOf(Balls) + "볼";
        }
        if (Balls == NO_COUNT) {
            return String.valueOf(Strikes) + "스트라이크";
        }
        return String.valueOf(Balls) + "볼 " + String.valueOf(Strikes) + "스트라이크";
    }

    private void validateStrikeCount(int strikes) {
        if (strikes < MIN_STRIKE_COUNT || strikes > MAX_STRIKE_COUNT) {
            throw new IllegalArgumentException("스트라이크는 0에서 3 사이 숫자만 집계합니다");
        }
    }

    private void validateBallCount(int balls) {
        if (balls < MIN_BALL_COUNT || balls > MAX_BALL_COUNT) {
            throw new IllegalArgumentException("볼은 0에서 3 사이 숫자만 집계합니다");
        }
    }
}
