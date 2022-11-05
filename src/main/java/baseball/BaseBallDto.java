package baseball;

public class BaseBallDto {

    private int strike;
    private int ball;

    public BaseBallDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getResult() {
        if (strike==0&&ball==0){
            return "낫싱";
        }
        return String.format("%s볼 %s스트라이크\n", ball, strike);
    }

}