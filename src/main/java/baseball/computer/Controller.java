package baseball.computer;

public class Controller {
    private final Computer computer = new Computer();
    private final int BALL_COUNT;

    public Controller(int BALL_COUNT) {
        this.BALL_COUNT = BALL_COUNT;
    }

    public int[] getBalls() {
        computer.makeBalls(BALL_COUNT);
        return computer.getBaseballs();
    }
}
