package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final int BALLS_SIZE = 3;

    private final List<Ball> balls = new ArrayList<>();

    public Balls(String inputBalls) {
        String[] splitBalls = inputBalls.split("");
        validateSize(splitBalls);
        addBalls(splitBalls);
    }

    private void validateSize(String[] splitBalls) {
        if (isValidSize(splitBalls)) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }
    }

    private boolean isValidSize(String[] splitBalls) {
        return Arrays.stream(splitBalls).collect(Collectors.toSet()).size() != BALLS_SIZE;
    }

    private void addBalls(String[] splitBalls) {
        for (int index = 0; index < splitBalls.length; index++) {
            balls.add(new Ball(index, Integer.parseInt(splitBalls[index])));
        }
    }

    public Result match(Balls balls) {
        Result result = new Result();
        for (Ball ball : balls.getBalls()) {
            result.add(match(ball));
        }
        return result;
    }

    private BallStatus match(Ball inputBall) {
        return this.balls.stream()
                .map(ball -> ball.match(inputBall))
                .filter(status -> !status.isNothing())
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
