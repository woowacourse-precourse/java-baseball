package baseball.domain;

import java.util.HashMap;

public class Ball {
    private static final int BALL_LOWER_BOUND = 0;
    private static final int BALL_UPPER_BOUND = 3;
    private static final HashMap<Integer, Ball> CACHE = new HashMap<>();

    static {
        for (int i = BALL_LOWER_BOUND; i <= BALL_UPPER_BOUND; i++) {
            CACHE.put(i, new Ball(i));
        }
    }

    private Integer count;

    private Ball(Integer count) {
        validate(count);
        this.count = count;
    }

    public static Ball valueOf(Integer count) {
        validate(count);
        return CACHE.get(count);
    }

    private static void validate(Integer number) {
        if (number < BALL_LOWER_BOUND || BALL_UPPER_BOUND < number) {
            throw new BaseballGameException();
        }
    }
}
