package baseball;

public enum Range {
    START(1),
    END(9);

    private final int point;

    Range(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
