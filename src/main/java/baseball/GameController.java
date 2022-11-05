package baseball;

import java.util.List;

public class GameController {
    Computer computer = new Computer();
    List<Integer> goalNumber = Computer.createRandomNumber();

    public static void start() {
        Message.start();
    }
}
