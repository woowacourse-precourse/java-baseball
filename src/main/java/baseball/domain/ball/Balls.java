package baseball.domain.ball;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> getBallNumbers() {
        return balls.stream()
                .map(Ball::getNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    public Integer getStrikeCount(Balls playerBall) {
        return (int) balls.stream()
                .filter(playerBall::isStrike)
                .count();
    }

    public Integer getBallCount(Balls playerBall) {
        return (int) balls.stream()
                .filter(playerBall::isBall)
                .count();
    }

    private boolean isStrike(Ball playerBall) {
        return balls.get(playerBall.getPosition()).isStrike(playerBall);
    }

    private boolean isBall(Ball playerBall) {
        return getBallNumbers().contains(playerBall.getNumber()) && !isStrike(playerBall);
    }
}
