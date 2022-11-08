package baseball.dto;

public class ScoreDTO {
    private Integer ballCount;
    private Integer strikeCount;

    public ScoreDTO() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public void plusStrikeCount() {
        this.strikeCount++;
    }

    public void plusBallCount() {
        this.ballCount++;
    }
}
