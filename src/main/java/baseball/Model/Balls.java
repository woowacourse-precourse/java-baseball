package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public List<Integer> balls = new ArrayList<>();

    public int getSize() {
        return balls.size();
    }

    public void add(int ball) {
        if(!balls.contains(ball)) {
            balls.add(ball);
        }
    }
}