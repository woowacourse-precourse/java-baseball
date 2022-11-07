package baseball.ball;

public final class Index {
    private static final int MINIMUM_INDEX_RANGE = 0;
    private static final int MAXIMUM_INDEX_RANGE = 2;
    private final int index;

    public Index(int index) {
        validateIndexRange(index);
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Index index1 = (Index) o;
        return index == index1.index;
    }

    private void validateIndexRange(int index) {
        if (index < MINIMUM_INDEX_RANGE || MAXIMUM_INDEX_RANGE < index) {
            throw new IllegalArgumentException("Ball의 index 범위가 벗어났습니다. index: " + index);
        }
    }
}
