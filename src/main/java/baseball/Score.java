package baseball;


public class Score {

    private int maxScore;
    private int strike;
    private int ball;
    private int fail;

    public Score(int maxScore) {
        this.strike = 0;
        this.ball = 0;
        this.fail = 0;
        this.maxScore = maxScore;
    }


}
