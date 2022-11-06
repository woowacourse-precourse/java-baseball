package baseball.domain;

import java.util.Arrays;

public enum BaseballGameResult {
    _3_STRIKE(3, 0, "3스트라이크"),
    _2_STRIKE(2, 0, "2스트라이크"),
    _1_STRIKE(1, 0, "1스트라이크"),
    _1_STRIKE_2_BALL(1, 2, "2볼 1스트라이크"),
    _1_STRIKE_1_BALL(1, 1, "1볼 1스트라이크"),
    _0_STRIKE_2_BALL(0, 2, "2볼"),
    _0_STRIKE_1_BALL(0, 1, "1볼"),
    _NOTHING(0, 0, "낫싱");

    private final int strike;
    private final int ball;
    private final String message;

    BaseballGameResult(int strike, int ball, String message) {
        this.strike = strike;
        this.ball = ball;
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static BaseballGameResult toEnum(int strike, int ball) {
        return Arrays.stream(values())
                .filter(e -> e.strike == strike && e.ball == ball)
                .findFirst()
                .orElseThrow(BaseballGameException::new);
    }
}
