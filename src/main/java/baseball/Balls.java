package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public boolean contains(Ball ball) {
        return balls.contains(ball);
    }

    public Ball get(int index) {
        return this.balls.get(index);
    }

    public int indexOf(Ball ball) {
        return balls.indexOf(ball);
    }

    public int size() {
        return balls.size();
    }

    @Override
    public boolean equals(Object obj) {
        Balls balls = (Balls) obj;
        return this.balls.equals(balls.balls);
    }
}
