package baseball;

public class GameState {
    private int strike;
    private int ball;

    public void addStrike() {
        ++strike;
    }
    public void addBall() {
        ++ball;
    }

    public int getStrike() { return strike; }
    public int getBall() { return ball; }
}
