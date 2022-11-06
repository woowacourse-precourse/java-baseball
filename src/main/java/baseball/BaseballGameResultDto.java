package baseball;

public class BaseballGameResultDto {
    int strike;
    int ball;
    boolean isCorrect;

    public BaseballGameResultDto(int strike,int ball,boolean isCorrect){
        this.strike = strike;
        this.ball = ball;
        this.isCorrect = isCorrect;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean getIsCorrect(){
        return isCorrect;
    }
}
