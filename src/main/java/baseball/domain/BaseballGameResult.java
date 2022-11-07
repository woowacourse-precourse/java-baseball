package baseball.domain;

import java.util.Arrays;

public enum BaseballGameResult {
    _3_STRIKE(Strike.valueOf(3), Ball.valueOf(0), "3스트라이크"),
    _2_STRIKE(Strike.valueOf(2), Ball.valueOf(0), "2스트라이크"),
    _1_STRIKE(Strike.valueOf(1), Ball.valueOf(0), "1스트라이크"),
    _1_STRIKE_2_BALL(Strike.valueOf(1), Ball.valueOf(2), "2볼 1스트라이크"),
    _1_STRIKE_1_BALL(Strike.valueOf(1), Ball.valueOf(1), "1볼 1스트라이크"),
    _3_BALL(Strike.valueOf(0), Ball.valueOf(3), "3볼"),
    _2_BALL(Strike.valueOf(0), Ball.valueOf(2), "2볼"),
    _1_BALL(Strike.valueOf(0), Ball.valueOf(1), "1볼"),
    _NOTHING(Strike.valueOf(0), Ball.valueOf(0), "낫싱");

    private final Strike strike;
    private final Ball ball;
    private final String message;

    BaseballGameResult(Strike strike, Ball ball, String message) {
        this.strike = strike;
        this.ball = ball;
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static BaseballGameResult toEnum(Strike strike, Ball ball) {
        return Arrays.stream(values())
                .filter(baseballGameResult -> isStrikeEqual(baseballGameResult, strike))
                .filter(baseballGameResult -> isBallEqual(baseballGameResult, ball))
                .findFirst()
                .orElseThrow(BaseballGameException::new);
    }

    private static boolean isStrikeEqual(BaseballGameResult baseballGameResult, Strike strike) {
        return baseballGameResult.strike.equals(strike);
    }

    private static boolean isBallEqual(BaseballGameResult baseballGameResult, Ball ball) {
        return baseballGameResult.ball.equals(ball);
    }

    public boolean isStrikeOut() {
        return this.strike.isStrikeOut();
    }
}
