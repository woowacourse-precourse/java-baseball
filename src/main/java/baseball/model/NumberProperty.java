package baseball.model;

public enum NumberProperty {
    SIZE(3),
    MIN_NUM(1),
    MAX_NUM(9);

    private final int property;

    NumberProperty(int property) {
        this.property = property;
    }

    public int get() {
        return property;
    }
}
