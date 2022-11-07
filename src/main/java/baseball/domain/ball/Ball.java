package baseball.domain.ball;

public class Ball {

    private int number;
    private int position;

    protected Ball() {

    }

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public static Ball create(int number, int position) {
        return new Ball(number, position);
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    public boolean isStrike(Ball ball) {
        return this.getNumber() == ball.getNumber() && this.getPosition() == ball.getPosition();
    }
}
