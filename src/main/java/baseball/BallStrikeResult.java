package baseball;

public class BallStrikeResult {
    private int ballCount;
    private int strikeCount;

    public BallStrikeResult() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public boolean doesWin() {
        return (this.strikeCount == GameNumber.GAME_NUMBER_LENGTH);
    }

    public String toString() {
        if(ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        } else if(ballCount == 0) {
            return strikeCount + "스트라이크";
        } else if(strikeCount == 0) {
            return ballCount + "볼";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallStrikeResult that = (BallStrikeResult) o;
        return ballCount == that.ballCount && strikeCount == that.strikeCount;
    }
}
