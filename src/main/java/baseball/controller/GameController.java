package baseball.controller;

import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final Messenger messenger;
    private final Computer computer;

    public GameController() {
        this.messenger = new Messenger();
        this.computer = new Computer();
    }

    public int compareBall(Ball userNumber){
        Ball computerNumber = computer.getComputerRandomNumber();
        int strike = computerNumber.compareByIndex(userNumber);
        int ball = computerNumber.compareByValue(userNumber) - strike;
        messenger.printResult(strike, ball);
        return strike;
    }

    public Ball receiveBall() {
        messenger.printInputMessage();
        String userInput = Console.readLine();
        return new Ball(userInput);
    }
}
