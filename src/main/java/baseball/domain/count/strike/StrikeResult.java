package baseball.domain.count.strike;

public class StrikeResult {

    private final int strikeCount;

    StrikeResult(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int strikeCount() {
        return strikeCount;
    }
}
