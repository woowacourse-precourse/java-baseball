package baseball.computer;

import java.util.List;

public class Controller {
    private final Computer computer = new Computer();

    public List<Integer> getBalls() {
        computer.makeBalls();
        return computer.getBaseballs();
    }
}
