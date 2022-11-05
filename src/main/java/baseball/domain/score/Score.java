package baseball.domain.score;

import java.util.Objects;

public class Score {
    private static final Integer FIX_SIZE = 3;
    private final Integer ball;
    private final Integer strike;


    private Score(final Integer ball, final Integer strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Score generateZero() {
        return new Score(0, 0);
    }

    public String result() {
        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        if (this.ball != 0) {
            result.append(this.ball).append("볼 ");
        }
        if (this.strike != 0) {
            result.append(this.strike).append("스트라이크");
        }
        return result.toString().trim();
    }

    public Score strike() {
        return new Score(this.ball, this.strike + 1);
    }

    public Score ball() {
        return new Score(this.ball + 1, this.strike);
    }

    public boolean strikeAll() {
        return Objects.equals(this.strike, FIX_SIZE);
    }
}
