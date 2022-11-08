package baseball;


import java.util.List;

public class Score {

    enum matchingTypes {FAIL, STRIKE, BALL}

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

    
    private void increase(matchingTypes type) {
        if (type == matchingTypes.FAIL) {
            increaseFail();
        } else if (type == matchingTypes.BALL) {
            increaseBall();
        } else if (type == matchingTypes.STRIKE) {
            increaseStrike();
        }
    }

    private void increaseStrike() {
        this.strike++;
    }

    private void increaseBall() {
        this.ball++;
    }

    private void increaseFail() {
        this.fail++;
    }


}
