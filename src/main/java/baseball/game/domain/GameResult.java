package baseball.game.domain;

public class GameResult {

    private int strike;
    private int ball;
    private boolean nothing;

    public void plusStrike() {
        this.strike += 1;
    }

    public void plusBall() {
        this.ball += 1;
    }

    public void setNothing() {
        if (this.strike == 0 && this.ball == 0) {
            this.nothing = Boolean.TRUE;
        } else {
            this.nothing = Boolean.FALSE;
        }
    }

    public String strikeToString() {
        if (isExistStrike())
            return String.format("%d스트라이크", this.strike);
        return "";
    }

    public String ballToString() {
        if (isExistBall())
            return String.format("%d볼", this.ball);
        return "";
    }

    public boolean isExistStrike() {
        return strike > 0;
    }

    public boolean isExistBall() {
        return ball > 0;
    }

    public boolean isNothing() {
        return nothing;
    }

    public String toString() {
        return ballToString() + " " + strikeToString();
    }

}
