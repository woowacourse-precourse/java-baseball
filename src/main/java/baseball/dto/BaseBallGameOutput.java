package baseball.dto;

public class BaseBallGameOutput {
    private int ballCount;
    private int strikeCount;

    public BaseBallGameOutput(int ballCount, int strikeCount) {
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
