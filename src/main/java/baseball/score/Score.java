package baseball.score;

import java.util.List;

import static baseball.score.ScoreStatus.*;

public class Score {

    private Integer ball;

    private Integer strike;

    public Score() {
        this.ball = 0;
        this.strike = 0;
    }

    public Integer getStrike() {
        return strike;
    }

    public void clear() {
        this.ball = 0;
        this.strike = 0;
    }

    public void countTotalScore(final List<ScoreStatus> scoreStatusList){

        for (ScoreStatus scoreStatus : scoreStatusList) {
            if (scoreStatus.equals(STRIKE)){
                strike++;
            }
            if (scoreStatus.equals(BALL)){
                ball ++;
            }
        }
    }

    public String printMessage(){
        String resultString ="";
        if (hasnotAnyBallAndStrike()){
            return NOTHING.getMessage();
        }
        if (hasBall()){
            resultString += ball + BALL.getMessage();
        }
        if (hasStrike()){
            resultString += strike + STRIKE.getMessage();
        }

        return resultString;
    }

    private boolean hasStrike() {
        return strike != 0;
    }

    private boolean hasBall() {
        return ball != 0;
    }

    private boolean hasnotAnyBallAndStrike() {
        return strike == 0 && ball == 0;
    }

    public void printScore(){
        System.out.println(printMessage());
    }
}
