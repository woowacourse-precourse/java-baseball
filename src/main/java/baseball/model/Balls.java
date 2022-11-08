package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {

    private static final String NUMBER_PATTERN = "\\d+";
    public static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> balls) {
        if (balls == null) {
            throw new IllegalArgumentException("볼이 생성되지 않았습니다.");
        }
        validateSize(balls);
        this.balls = mapToBalls(balls);
    }

    private List<Ball> mapToBalls(List<Integer> inputBalls) {
        List<Ball> balls = new ArrayList<>();
        for (int index = 0; index < inputBalls.size(); index++) {
            Ball ball = new Ball(index, inputBalls.get(index));
            balls.add(ball);
        }
        return balls;
    }

    private void validateSize(List<Integer> balls) {
        if (isValidSize(balls)) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }
    }

    private boolean isValidSize(List<Integer> balls) {
        return balls.size() != BALLS_SIZE;
    }

    public Balls(String inputBalls) {
        this(parseInt(inputBalls));
    }

    private static List<Integer> parseInt(String inputBalls) {
        validateNumber(inputBalls);
        List<Integer> balls = new ArrayList<>();
        for (String ball : inputBalls.split("")) {
            addBalls(balls, Integer.parseInt(ball));
        }
        return balls;
    }

    private static void validateNumber(String balls) {
        if (!balls.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static void addBalls(List<Integer> balls, int ball) {
        if (balls.contains(ball)) {
            throw new IllegalArgumentException("중복된 숫자입니다.");
        }
        balls.add(ball);
    }

    public Result match(Balls balls) {
        Result result = new Result();
        for (Ball ball : balls.getBalls()) {
            result.add(match(ball));
        }
        return result;
    }

    private BallStatus match(Ball inputBall) {
        return balls.stream()
                .map(ball -> ball.match(inputBall))
                .filter(status -> !status.isNothing())
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
