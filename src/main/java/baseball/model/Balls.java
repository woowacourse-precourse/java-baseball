package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
    private final List<Integer> balls = new ArrayList<>();

    public Balls(int balls) {
        while (balls > 0) {
            this.balls.add(balls % 10);
            balls /= 10;
        }
        Collections.reverse(this.balls);
    }

    public boolean compare(int ball, int position) {
        for (int i = 0; i < balls.size(); i++) {
            if (i == position && balls.get(i).equals(ball)) {
                return true;
            }
        }
        return false;
    }
}
