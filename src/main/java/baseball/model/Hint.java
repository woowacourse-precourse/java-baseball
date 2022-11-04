package baseball.model;

public class Hint {
    private final int strike;
    private final int ball;
    public Hint(int ball, int strike){
        if(ball <= 3 && strike <=3){
            this.ball = ball;
            this.strike = strike;
        }else{
            throw new IllegalStateException("ball과 strike는 0이상 3 미만이어야 합니다.");
        }

    }
    @Override
    public String toString() {
        return ball + "볼 " + strike + "스트라이크\n";
    }
}
