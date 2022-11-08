package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    // 생성시 예외 검증 로직 필요
    public PlayResult(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public boolean success() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
