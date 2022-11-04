package baseball;

import java.util.List;

public class GameController {

    public static void start() {
        Message.start();
        List<Integer> goalNumber = Computer.createRandomNumber();
    }
}
