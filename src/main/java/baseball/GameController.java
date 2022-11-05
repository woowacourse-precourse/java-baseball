package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.nio.channels.IllegalChannelGroupException;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    Computer computer = new Computer();
    List<Integer> goalNumber = Computer.createRandomNumber();

    public static void start() {
        Message.start();
    }

    public void playing() {
        List<Integer> userNumber = getUserNumber();
    }

    public List<Integer> getUserNumber() throws IllegalArgumentException {
        List<Integer> userNumber = new ArrayList<>();
        Message.getUserNumber();
        String inputNumber = Console.readLine();

        return userNumber;
    }
}
