package baseball.domain;

import baseball.domain.game.GameMessage;

import java.util.List;

public class StrikeAndBallDomain {
    int strike, ball;

    public StrikeAndBallDomain() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    private void addStrike() {
        this.strike++;
    }

    private void addBall() {
        this.ball++;
    }

    public GameMessage getResult() {
        return GameMessage.findStrikeAndBallMessage(this);
    }

    private void isStrike(int computerDigit, int userDigit) {
        if (computerDigit == userDigit) {
            addStrike();
        }
    }

    private void isBall(int computerDigit, int userDigit, List<Integer> computer) {
        if ((computerDigit != userDigit) && (computer.contains(userDigit))) {
            addBall();
        }
    }

    public void isStrikeOrBall(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            isStrike(computer.get(i), user.get(i));
            isBall(computer.get(i), user.get(i), computer);
        }
    }
}
