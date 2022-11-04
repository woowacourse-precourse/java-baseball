package baseball.domain;

import static baseball.domain.Balls.BALLS_FORMAL_SIZE;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Hint {

    private static final int INIT_POINT = 0;
    private static final int POINT_UNIT = 1;
    private final Map<Score, Integer> points;

    public Hint() {
        this.points = new EnumMap<>(Score.class);
    }


    public void init() {
        Arrays.stream(Score.values()).forEach(i -> points.put(i, INIT_POINT));
    }

    public void increasePoint(Score score) {
        points.put(score, points.get(score) + POINT_UNIT);
    }

    public boolean isOut() {
        return points.get(Score.STRIKE) == BALLS_FORMAL_SIZE;
    }

    public int getScorePoint(Score score) {
        return points.get(score);
    }
}
