package baseball.domain;

public class CountCheck {


    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public CountCheck() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isAllCountExist() {
        return !(isStrikeCountEmpty() || isBallCountEmpty());
    }

    public boolean isAllCountEmpty() {
        return isStrikeCountEmpty() && isBallCountEmpty();
    }

    public boolean isBallCountEmpty() {
        return ballCount == 0;
    }

    public boolean isStrikeCountEmpty() {
        return strikeCount == 0;
    }

    public void addStrikeCount() {
        ++strikeCount;
    }

    public void addBallCount() {
        ++ballCount;
    }

    public boolean isAnswer() {
        return strikeCount == 3;
    }
}
