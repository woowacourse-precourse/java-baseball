package baseball;

import java.util.ArrayList;
import java.util.List;
import static baseball.Const.SIZE;
import static baseball.Const.WRONG_INPUT;

public class CollectionBalls { // name
    private List<Ball> ballList;

    public CollectionBalls() {
        this.ballList = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        this.ballList.add(ball);
    }

    public boolean isDuplicate(Ball ball) {
        return ballList.contains(ball);
    }

    public void generate() {
        ballList.clear();

        while (this.ballList.size() != SIZE) {
            Ball ball = new Ball();
            ball.generate();

            if (!isDuplicate(ball)) {
                ballList.add(ball);
            }
        }
    }

    public List<Ball> getBallList() {
        return this.ballList;
    }

    public void convertInputToBall(String input) {
        ballList.clear();

        if (input.length() != SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }

        for (int i = 0; i < SIZE; i++) {
            Ball additionalBall = new Ball(input.charAt(i));
            ballList.add(additionalBall);
        }
    }
}
