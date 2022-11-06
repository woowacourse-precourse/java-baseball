package baseball;

public final class BallStrikeResult {
    private final int ballCount;
    private final int strikeCount;

    public BallStrikeResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean doesWin() {
        return (this.strikeCount == TargetNumber.TARGET_NUMBER_LENGTH);
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
