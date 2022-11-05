package baseball.core.dto;

public class BallStrikeDto {

    private final int ballCount;
    private final int strikeCount;

    public BallStrikeDto(int ballCount, int strikeCount) {
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
