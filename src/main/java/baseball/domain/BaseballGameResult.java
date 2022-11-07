package baseball.domain;

import java.text.MessageFormat;
import java.util.Arrays;

public enum BaseballGameResult {
    _3_STRIKE(Strike.valueOf(3), Ball.valueOf(0)),
    _2_STRIKE(Strike.valueOf(2), Ball.valueOf(0)),
    _1_STRIKE(Strike.valueOf(1), Ball.valueOf(0)),
    _1_STRIKE_2_BALL(Strike.valueOf(1), Ball.valueOf(2)),
    _1_STRIKE_1_BALL(Strike.valueOf(1), Ball.valueOf(1)),
    _3_BALL(Strike.valueOf(0), Ball.valueOf(3)),
    _2_BALL(Strike.valueOf(0), Ball.valueOf(2)),
    _1_BALL(Strike.valueOf(0), Ball.valueOf(1)),
    _NOTHING(Strike.valueOf(0), Ball.valueOf(0));

    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String DEFAULT_MESSAGE_FORMAT = "{0}{1}";
    private static final String DELIMITER_MESSAGE_FORMAT = "{0} {1}";

    private final Strike strike;
    private final Ball ball;

    BaseballGameResult(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return NOTHING_MESSAGE;
        }
        if (isNeedDelimiter()) {
            return MessageFormat.format(DELIMITER_MESSAGE_FORMAT, ball, strike);
        }
        return MessageFormat.format(DEFAULT_MESSAGE_FORMAT, ball, strike);
    }

    private boolean isNothing() {
        return this.equals(_NOTHING);
    }

    private boolean isNeedDelimiter() {
        return this.equals(_1_STRIKE_1_BALL) || this.equals(_1_STRIKE_2_BALL);
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
