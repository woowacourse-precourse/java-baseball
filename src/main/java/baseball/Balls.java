package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> ballList;

    public Balls() {
        this.ballList = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        this.ballList.add(ball);
    }

    public boolean checkDuplicate(Ball ball) {
        return ballList.contains(ball);
    }
}
