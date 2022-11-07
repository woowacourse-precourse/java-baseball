package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Integer> balls = new ArrayList<>();

    public int getSize() {
        return balls.size();
    }

    public void add(int ball) {
        if(!balls.contains(ball)) {
            balls.add(ball);
        }
    }
}