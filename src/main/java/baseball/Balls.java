package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public boolean equals(Object obj) {
        Balls balls = (Balls) obj;
        return this.balls.equals(balls.balls);
    }
}
