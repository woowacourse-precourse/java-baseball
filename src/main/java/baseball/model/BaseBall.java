package baseball.model;

public class BaseBall {
    private int strike;
    private int ball;
    private boolean isWin;

    public BaseBall() {
        this.strike = 0;
        this.ball = 0;
        this.isWin = false;
    }

    public void setStrike(int strikeCount) {
        this.strike = strikeCount;
    }

    public void setBall(int ballCount) {
        this.ball = ballCount;
    }

    public void setWin(boolean isWin) {
        this.isWin = isWin;
    }

    public void resetCount() {
        this.strike = 0;
        this.ball = 0;
        this.isWin = false;
    }

    public boolean isWin() {
        return isWin;
    }

    public void winGame() {
        this.isWin = true;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNotting() {
        return strike == 0 && ball == 0;
    }
}
