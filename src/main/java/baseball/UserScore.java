package baseball;

public class UserScore {
    private int ballCount;
    private int strikeCount;

    public void init() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void set(int b, int s) {
        ballCount = b;
        strikeCount = s;
    }

    public int getBall() {
        return this.ballCount;
    }

    public int getStrike() {
        return this.strikeCount;
    }

    public void addBall() {
        this.ballCount += 1;
    }

    public void addStrike() {
        this.strikeCount += 1;
        this.ballCount -= 1;
    }
}
