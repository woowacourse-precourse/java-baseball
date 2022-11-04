package baseball.model;

public class Hint {
    private int strike;
    private int ball;
    public Hint(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }
    @Override
    public String toString() {
        return ball + "볼 " + strike + "스트라이크\n";
    }
}
