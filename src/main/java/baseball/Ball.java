package baseball;

import java.util.List;

public class Ball {
    private int number;
    private int order;

    public Ball(int number, int order) {
        this.number = number;
        this.order = order;
    }

    public BaseballJudge getResult(List<Ball> balls) {
        if (isStrike(balls)) {
            return BaseballJudge.STRIKE;
        }

        if (isBall(balls)) {
            return BaseballJudge.BALL;
        }

        return BaseballJudge.NOTHING;
    }

    private boolean isStrike(List<Ball> balls) {
        return number == balls.get(order).getNumber();
    }

    private boolean isBall(List<Ball> balls) {
        return balls.stream().anyMatch(ball ->
                ball.getNumber() == this.number && ball.getOrder() != this.order);
    }

    public int getNumber() {
        return number;
    }

    public int getOrder() {
        return order;
    }
}
