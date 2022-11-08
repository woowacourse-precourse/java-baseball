package baseball.domain;

import baseball.resource.GameMessage;

public class BaseballResult {
    private int strike;
    private int ball;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getStrikeMessage() {
        return getStrike() + GameMessage.GAME_STRIKE;
    }

    public String getBallMessage() {
        return getStrike() + GameMessage.GAME_BALL;
    }

    public boolean isThreeStrike() {
        return getStrike() == 3;
    }

    @Override
    public String toString() {
        if (getStrike() > 0 && getBall() > 0) {
            return getBallMessage() + " " + getStrikeMessage();
        }

        if (getStrike() > 0 && getBall() == 0) {
            return getStrikeMessage();
        }

        if (getStrike() == 0 && getBall() > 0) {
            return getBallMessage();
        }

        return GameMessage.GAME_NOTHING;
    }
}
