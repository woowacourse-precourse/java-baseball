package baseball.game.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount(TargetNumber answer, TargetNumber input) {
        AtomicInteger strike = new AtomicInteger();
        AtomicInteger ball = new AtomicInteger();

        answer.indexedForEach((a, i) -> input.indexedForEach((n, j) -> {
            if (!a.equals(n)) {
                return;
            }
            if (i.equals(j)) {
                strike.addAndGet(1);
            } else {
                ball.addAndGet(1);
            }
        }));

        this.strike = strike.get();
        this.ball = ball.get();
    }

    private String getStrike() {
        if (strike > 0) {
            return strike + "스트라이크 ";
        }
        return "";
    }

    private String getBall() {
        if (ball > 0) {
            return ball + "볼 ";
        }
        return "";
    }

    @Override
    public String toString() {
        String ballString = getBall();
        String strikeString = getStrike();

        if (Objects.equals(ballString, "") && Objects.equals(strikeString, "")) {
            return "낫싱";
        }

        return ballString + strikeString;
    }

    public boolean isCorrect(int count) {
        return strike == count;
    }
}
