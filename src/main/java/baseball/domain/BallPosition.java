package baseball.domain;

import java.util.Objects;

public class BallPosition {
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "Position 은 0~2 사이여야 합니다.";
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 2;
    
    private final int position;
    
    public BallPosition(final int position) {
        validateRange(position);
        this.position = position;
    }
    
    private void validateRange(final int position) {
        if (isPositionOutOfRange(position)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
    
    private boolean isPositionOutOfRange(final int position) {
        return position < MIN_POSITION || position > MAX_POSITION;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BallPosition that = (BallPosition) o;
        return position == that.position;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
    
    @Override
    public String toString() {
        return "BallPosition{" +
                "position=" + position +
                '}';
    }
}
