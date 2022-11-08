package baseball.domain;

import java.util.Arrays;
import java.util.List;

import static baseball.type.BaseballBound.BASEBALL_MAX_SIZE;

public class Hint {
    private final int strikes;
    private final int balls;

    public Hint(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isFullStrikes() {
        return (strikes == BASEBALL_MAX_SIZE.getValue());
    }

    public List<Integer> getStrikeBallCount() {
        return Arrays.asList(strikes, balls);
    }
}
