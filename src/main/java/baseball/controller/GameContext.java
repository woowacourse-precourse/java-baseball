package baseball.controller;

import baseball.domain.Action;
import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import camp.nextstep.edu.missionutils.Console;

public class GameContext {
    Messenger messenger;
    GameStrategy gameStrategy;

    public GameContext(GameStrategy gameStrategy) {
        this.messenger = new Messenger();
        this.gameStrategy = gameStrategy;
    }

    public void runGameMain() {
        startGame();
        Ball computerBall = setComputerBall();
        Action action = initializeStartAction();

        while (action.isStart()) {
            gameStrategy.runBaseballGame(computerBall);
            action = receiveUserAction();
            computerBall = resetComputerBall(action);
        }
    }

    private void startGame() {
        messenger.printStartMessage();
    }

    private Ball setComputerBall() {
        Computer computer = new Computer();
        return computer.createRandomBall();
    }

    private Action initializeStartAction() {
        return new Action(Action.START);
    }

    private Action receiveUserAction() {
        messenger.printRestartOrEndMessage();
        return new Action(Console.readLine());
    }

    private Ball resetComputerBall(Action userAction) {
        Ball computerBall = null;
        if (userAction.isStart()) {
            computerBall = setComputerBall();
        }
        return computerBall;
    }
}
