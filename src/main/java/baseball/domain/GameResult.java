package baseball.domain;

public class GameResult {
    private static final int MIN_SCORE_COUNT = 0;
    private static final int MAX_SCORE_COUNT = 3;

    private final int ballCounts;
    private final int strikeCounts;

    public GameResult(int ballCounts, int strikeCounts) {
        validateInput(ballCounts, strikeCounts);
        this.ballCounts = ballCounts;
        this.strikeCounts = strikeCounts;
    }

    private void validateInput(int ballCounts, int strikeCounts) {
        if (ballCounts < MIN_SCORE_COUNT || ballCounts > MAX_SCORE_COUNT) {
            throw new IllegalArgumentException(
                    String.format("유효하지 않은 결과 입니다. (스트라이크: %d, 볼: %d", strikeCounts, ballCounts));
        }
        if (strikeCounts < MIN_SCORE_COUNT || strikeCounts > MAX_SCORE_COUNT) {
            throw new IllegalArgumentException(
                    String.format("유효하지 않은 결과 입니다. (스트라이크: %d, 볼: %d", strikeCounts, ballCounts));
        }
        if (ballCounts + strikeCounts > MAX_SCORE_COUNT) {
            throw new IllegalArgumentException(
                    String.format("유효하지 않은 결과 입니다. (스트라이크: %d, 볼: %d", strikeCounts, ballCounts));
        }
    }

    public boolean isGameEnds() {
        return this.strikeCounts == MAX_SCORE_COUNT;
    }

    public boolean isNothing() {
        return this.ballCounts == MIN_SCORE_COUNT && this.strikeCounts == MIN_SCORE_COUNT;
    }

    public boolean isOnlyStrike() {
        return this.ballCounts == MIN_SCORE_COUNT && this.strikeCounts != MIN_SCORE_COUNT;
    }

    public boolean isOnlyBall() {
        return this.ballCounts != MIN_SCORE_COUNT && this.strikeCounts == MIN_SCORE_COUNT;
    }

    public int getBallCounts() {
        return this.ballCounts;
    }

    public int getStrikeCounts() {
        return this.strikeCounts;
    }
}
