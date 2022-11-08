package baseball.model;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class BallCount {
    private int strike;
    private int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else if (ball == 0) {
            return strike  + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}