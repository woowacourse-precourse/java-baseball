package baseball.model;

public class BallPosition {
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;

    private int value;

    private BallPosition(int value) {
        this.value = value;
    }

    public static BallPosition from(int position) {
        validate(position);
        
        return new BallPosition(position);
    }

    private static void validate(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException("공 위치는 1~3 사이 값만 생성 가능합니다.");
        }
    }

    public int value() {
        return this.value;
    }
}
