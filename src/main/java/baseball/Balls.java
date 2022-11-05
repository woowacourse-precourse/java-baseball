package baseball;

import java.util.ArrayList;
import java.util.List;
import static baseball.Const.SIZE;

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

    public void generate() {
        while (this.ballList.size() != SIZE) {
            Ball ball = new Ball();
            ball.generate();

            if (!checkDuplicate(ball)) {
                ballList.add(ball);
            }
        }
    }

    public List<Ball> getBallList() {
        return this.ballList;
    }

    public
}
