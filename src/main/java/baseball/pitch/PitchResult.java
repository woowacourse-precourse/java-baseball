package baseball.pitch;

public class PitchResult {
    private int ball;
    private int strike;

    public PitchResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public String getPitchResultString() {

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if(strike == 3) {
            return "3스트라이크";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
