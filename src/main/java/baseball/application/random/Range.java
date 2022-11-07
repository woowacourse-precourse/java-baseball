package baseball.application.random;

public class Range {
    private final int startInclusive;
    private final int endInclusive;

    public Range(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public int startInclusive() {
        return startInclusive;
    }

    public int endInclusive() {
        return endInclusive;
    }
}
