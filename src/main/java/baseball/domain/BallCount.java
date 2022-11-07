package baseball.domain;

import baseball.message.BallCountMessage;

import java.util.ArrayList;
import java.util.List;

public class BallCount {

    private int strikes;
    private int balls;

    public void initBallCount(){
        this.strikes = 0;
        this.balls = 0;
    }

    public void increaseStrike(){
        this.strikes++;
    }
    public void increaseBall(){
        this.balls++;
    }
    public boolean isStrikeThree() {
        return this.strikes == 3;
    }
    private String getStrikes() {
        return strikes + BallCountMessage.STRIKE;
    }
    private String getBalls() {
        return balls + BallCountMessage.BALL;
    }
    private boolean isStrikeZero() {
        return this.strikes == 0;
    }
    private boolean isBallZero() {
        return this.balls == 0;
    }

    public String makeResultString() {
        List<String> resultString = new ArrayList<>();
        if(!isBallZero()) {
            resultString.add(getBalls());
        }
        if(!isStrikeZero()) {
            resultString.add(getStrikes());
        }
        if(resultString.size() == 0) {
            resultString.add(BallCountMessage.NOTHING);
        }
        String result = String.join(" ", resultString);
        return result;
    }
}
