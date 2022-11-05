package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameMessage;
import baseball.view.InputMessage;

public class GameController {
    private GameMessage gameMessage = new GameMessage();
    private InputMessage inputMessage = new InputMessage();
    private User user = new User();
    private Computer computer = new Computer();

    public void start() {
        gameMessage.startGame();
        computer.throwTheBall();
    }

    public void play() {
        inputMessage.inputNumber();
        user.hitTheBall();
    }
}
