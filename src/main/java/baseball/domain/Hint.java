package baseball.domain;

/**
 * 숫자야구 힌트가 담긴 클래스
 */
public class Hint {
    private int ball;
    private int strike;

    public Hint() {
        this.ball = 0;
        this.strike = 0;
    }

    public void increaseBall() {
        this.ball += 1;
    }

    public void increaseStrike() {
        this.strike += 1;
    }

}
