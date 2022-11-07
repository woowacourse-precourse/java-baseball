package baseball;

public class Ball {

    private final Integer number;
    Validator validator = new Validator();

    public Ball(int ball) {
        validator.validateRange(ball);
        this.number = ball;
    }

    @Override
    public boolean equals(Object obj) {
        Ball ball = (Ball) obj;
        return this.number == ball.number;
    }

    @Override
    public int hashCode() {
        if (number == null) {
            return 0;
        }
        return number.hashCode();
    }
}
