package baseball.domain;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public enum Hint {
    BALL(
            result -> String.format("%s볼", result.ball),
            result -> result.ball > 0 && result.strike == 0
    ),
    STRIKE(
            result -> String.format("%s스트라이크", result.strike),
            result -> result.ball == 0 && result.strike > 0
    ),
    BALL_AND_STRIKE(
            result -> String.format("%s볼 %s스트라이크", result.ball, result.strike),
            result -> result.ball > 0 && result.strike > 0
    ),
    NOTING(
            result -> "낫싱",
            result -> result.ball == 0 && result.strike == 0
    );

    private final Function<Result, String> message;
    private final Predicate<Result> predicate;

    Hint(Function<Result, String> message, Predicate<Result> predicate) {
        this.message = message;
        this.predicate = predicate;
    }

    public static Hint getHint(int ball, int strike) {
        return Arrays.stream(Hint.values())
                .filter(answer -> answer.test(ball, strike))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getMessage(int ball, int strike) {
        return message.apply(new Result(ball, strike));
    }

    private boolean test(int ball, int strike) {
        return predicate.test(new Result(ball, strike));
    }

    class Result {
        int ball;
        int strike;

        public Result(int ball, int strike) {
            this.ball = ball;
            this.strike = strike;
        }
    }
}
