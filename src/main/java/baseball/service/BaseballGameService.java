package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.printer.GameGuidePrinter;
import baseball.util.RandomNumber;


public class BaseballGameService {

    private User user;
    private Computer computer;


    public void initGame(int start, int end, int size) {
        computer = new Computer(RandomNumber.getRandomNumbers(start, end, size));
        GameGuidePrinter.startGameMessage();
    }

}
