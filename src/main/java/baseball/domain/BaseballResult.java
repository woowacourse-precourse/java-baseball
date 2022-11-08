package baseball.domain;

import baseball.resource.GameMessage;
import baseball.resource.GameValue;

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
        return getBall() + GameMessage.GAME_BALL;
    }

    public boolean isThreeStrike() {
        return getStrike() == GameValue.THREE_STRIKE;
    }

    @Override
    public String toString() {
        if (getStrike() > GameValue.ZERO && getBall() > GameValue.ZERO) {
            return String.join(" ", getBallMessage(), getStrikeMessage());
        }

        if (getStrike() > GameValue.ZERO && getBall() == GameValue.ZERO) {
            return getStrikeMessage();
        }

        if (getStrike() == GameValue.ZERO && getBall() > GameValue.ZERO) {
            return getBallMessage();
        }

        return GameMessage.GAME_NOTHING;
    }
}
