package baseball.model;

public class HintReq {
    private final int ballCount;
    private final int strikeCount;

    public HintReq(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
