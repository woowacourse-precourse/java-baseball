package baseball.controller;


import baseball.domain.Computer;
import baseball.domain.User;
import java.util.List;

public class BaseballGameController {

    private Computer computer = new Computer();
    private User user;
    private final String RESTART = "1";
    private final int THREE_STRIKE = 3;


    public void startGame() {
        computer.setRandomNumber();
        List<Integer> computerRandomNumber = computer.getRandomNumber();
    }
}



