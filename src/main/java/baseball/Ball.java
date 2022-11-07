package baseball;

public class Ball {
    private final int number;
    private final int order;

    public Ball(int number, int order) {
        validateNumberRange(number);
        this.number = number;
        this.order = order;
    }

    public BaseballJudge getResult(Balls balls) {
        if (isStrike(balls)) {
            return BaseballJudge.STRIKE;
        }

        if (isBall(balls)) {
            return BaseballJudge.BALL;
        }

        return BaseballJudge.NOTHING;
    }

    private boolean isStrike(Balls balls) {
        return number == balls.getBalls().get(order).getNumber();
    }

    private boolean isBall(Balls balls) {
        return balls.getBalls().stream()
                .anyMatch(this::isEqualNumberAndNotEqualOrder);
    }

    private boolean isEqualNumberAndNotEqualOrder(Ball ball) {
        return ball.getNumber() == this.number && ball.getOrder() != this.order;
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(BaseballMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    public int getOrder() {
        return order;
    }
}
