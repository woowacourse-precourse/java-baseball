package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BallFactory {

    public static Balls createBalls(List<Integer> numbers) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            ballList.add(Ball.of(numbers.get(i), i + 1));
        }
        return Balls.of(ballList);
    }
}
