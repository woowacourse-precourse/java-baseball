package baseball.computer;

import java.util.List;

public class Controller {
    private final Computer computer = new Computer();

    public List<Integer> makeBalls() {
        computer.makeBalls();
        return computer.getBaseballs();
    }
}
