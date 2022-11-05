package baseball.domain.count;

public class CountResult {

    private final int ballCount;
    private final int strikeCount;

    public CountResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }

    public int strikeCount() {
        return strikeCount;
    }
}
