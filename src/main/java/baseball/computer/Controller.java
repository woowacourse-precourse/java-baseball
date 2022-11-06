package baseball.computer;

public class Controller {
    private final Computer computer = new Computer();

    public Controller() {
    }

    public int[] getBalls() {
        computer.makeBalls();
        return computer.getBaseballs();
    }
}
