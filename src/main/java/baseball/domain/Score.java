package baseball.domain;


public class Score {

    private int strikeCount;
    private int ballCount;

    private Score() {
    }

    public static Score of() {
        return new Score();
    }

    public void init() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setScore(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

}
