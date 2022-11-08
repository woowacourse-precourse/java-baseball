package baseball;

public class BaseballGameResultDto {
    int strike;
    int ball;

    public BaseballGameResultDto(int strike,int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
