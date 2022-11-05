package baseball.controller;

import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final Messenger messenger;
    private Ball computerNumber;

    public GameController() {
        this.messenger = new Messenger();
    }

    public int compareBall(Ball userNumber){
        int strike = computerNumber.compareByIndex(userNumber);
        int ball = computerNumber.compareByValue(userNumber) - strike;
        messenger.printResultMessage(strike, ball);
        return strike;
    }

    public Ball receiveBall() {
        messenger.printInputMessage();
        String userInput = Console.readLine();
        return new Ball(userInput);
    }

    public void setComputerNumber() {
        Computer computer = new Computer();
        computer.setComputerRandomNumber();
        this.computerNumber = computer.getComputerRandomNumber();
    }
}
