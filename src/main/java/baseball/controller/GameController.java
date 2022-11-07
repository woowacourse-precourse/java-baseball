package baseball.controller;

import baseball.constant.Constant;
import baseball.domain.Action;
import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final Messenger messenger;
    private final int ZERO_STRIKE = 0;
    private final int THREE_STRIKES = 3;
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

    public Action receiveUserAction() {
        messenger.printRestartOrEndMessage();
        return new Action(Console.readLine());
    }

    public boolean receiveRestartOrEndIntent() {
        Action userAction = receiveUserAction();
        if (userAction.isRestart()) {
            setComputerNumber();
        }
        return userAction.isRestart();
    }

    public void runBaseballGame() {
        int strike = ZERO_STRIKE;
        while (strike < THREE_STRIKES) {
            Ball userNumber = receiveBall();
            strike = compareBall(userNumber);
        }
        messenger.printAnswerMessage();
    }

    public void startGame() {
        messenger.printStartMessage();
        setComputerNumber();
    }

    public void runGameMain() {
        boolean connection = true;
        startGame();
        while (connection) {
            runBaseballGame();
            connection = receiveRestartOrEndIntent();
        }
    }
}
