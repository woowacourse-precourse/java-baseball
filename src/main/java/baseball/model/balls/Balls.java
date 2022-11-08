package baseball.model.balls;

import baseball.model.ball.Ball;
import baseball.model.ball.BallNumber;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {

    public static final int BALLS_MAX_SIZE = 3;
    public static final int BALLS_START_POSITION = 0;
    public static final String BALLS_RANGE_ERROR = "ball의 개수가 3개 이여야 합니다.";
    private final List<Ball> balls;

    public Balls(List<Integer> userBalls) {
        checkRange(userBalls);
        this.balls = userBalls.stream()
                .map(BallNumber::new)
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    private static void checkRange(List<Integer> userBalls) {
        if (userBalls.size() != BALLS_MAX_SIZE) {
            throw new IllegalArgumentException(BALLS_RANGE_ERROR);
        }
    }


    public boolean contains(Ball ball) {
        return balls.contains(ball);
    }

    public BallReport judge(Balls computerBalls) {
        BallReport ballReport = new BallReport();
        IntStream.range(BALLS_START_POSITION, BALLS_MAX_SIZE)
                .forEachOrdered(position -> ballReport.add(computerBalls.judge(position, balls.get(position), this)));
        return ballReport;
    }

    private JudgementType judge(int position, Ball computerBall, Balls computerBalls) {
        Ball ball = balls.get(position);
        if (ball.equals(computerBall)) {
            return JudgementType.STRIKE;
        }
        if (computerBalls.contains(ball)) {
            return JudgementType.BALL;
        }
        return JudgementType.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Balls)) {
            return false;
        }
        Balls ballList1 = (Balls) o;
        return Objects.equals(balls, ballList1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
