package baseball;

import java.util.List;

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
            if (scoreStatus.equals(ScoreStatus.STRIKE)){
                strike++;
            }
            if (scoreStatus.equals(ScoreStatus.BALL)){
                ball ++;
            }
        }
    }

    public String printMessage(){
        String resultString ="";
        if (strike == 0 && ball == 0){
            return ScoreStatus.NOTHING.getMessage();
        }
        if (ball !=0){
            resultString += resultString + ball +ScoreStatus.BALL.getMessage();
        }
        if (strike !=0){
            resultString += resultString + strike +ScoreStatus.STRIKE.getMessage();
        }

        return resultString;
    }
    public void printScore(){
        System.out.println(printMessage());
    }
}
