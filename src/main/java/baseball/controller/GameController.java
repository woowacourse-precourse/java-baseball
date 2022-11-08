package baseball.controller;

import baseball.domain.Action;
import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final Messenger messenger;
    private Ball computerBall;
    private static final int ZERO_STRIKE = 0;
    private static final int THREE_STRIKES = 3;

    public GameController() {
        this.messenger = new Messenger();
    }

    public int compareComputerBallWith(Ball userBall) {
        int strike = computerBall.compareByIndex(userBall);
        int ball = computerBall.compareByValue(userBall) - strike;
        messenger.printResultMessage(strike, ball);
        return strike;
    }

    public Ball receiveUserBall() {
        messenger.printInputMessage();
        return new Ball(Console.readLine());
    }

    public void setComputerBall() {
        Computer computer = new Computer();
        this.computerBall = computer.createRandomBall();
    }

    public Action receiveUserAction() {
        messenger.printRestartOrEndMessage();
        return new Action(Console.readLine());
    }

    public void resetComputerBall(Action userAction) {
        if (userAction.isStart()) {
            setComputerBall();
        }
    }

    public void runBaseballGame() {
        int strike = ZERO_STRIKE;
        while (strike < THREE_STRIKES) {
            Ball userBall = receiveUserBall();
            strike = compareComputerBallWith(userBall);
        }
        messenger.printAnswerMessage();
    }

    public void startGame() {
        messenger.printStartMessage();
        setComputerBall();
    }

    public Action initializeStartAction() {
        return new Action(Action.START);
    }

    public void runGameMain() {
        startGame();
        Action action = initializeStartAction();

        while (action.isStart()) {
            runBaseballGame();
            action = receiveUserAction();
            resetComputerBall(action);
        }
    }
}
