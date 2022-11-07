package baseball.domain.ball;

import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(List<Ball> balls) {
        return new Balls(balls);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public Integer getStrikeCount(Balls answerBall) {
        return (int) balls.stream()
                .filter(answerBall::isStrike)
                .count();
    }

    public Integer getBallCount(Balls answerBall) {
        return (int) balls.stream()
                .filter(answerBall::isBall)
                .count();
    }

    private boolean isStrike(Ball ball) {
        return balls.get(ball.getPosition()).isStrike(ball);
    }

    private boolean isBall(Ball ball) {
        return balls.get(ball.getPosition()).isBall(ball);
    }
}
