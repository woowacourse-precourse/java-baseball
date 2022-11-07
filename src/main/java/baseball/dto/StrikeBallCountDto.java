package baseball.dto;

public class StrikeBallCountDto {
    private int strikeCount;
    private int ballCount;

    public StrikeBallCountDto(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
