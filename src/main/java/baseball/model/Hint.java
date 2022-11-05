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
        if(ball == 0 && strike == 0){
            return "낫싱\n";
        }else if(ball == 0){
            return strike + "스트라이크\n";
        }else if(strike == 0){
            return ball + "볼\n";
        }
        return ball + "볼 " + strike + "스트라이크\n";
    }
}
