package baseball.domain;

public class Referee {
    public final int INPUT_SIZE = 3;
    public int strike = 0;
    public int ball = 0;

    public void clear() {
        this.strike = 0;
        this.ball = 0;
    }
}
