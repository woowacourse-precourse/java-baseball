package baseball;

import baseball.view.GameMessage;
import baseball.view.InputMessage;

public class Baseball {
    private GameMessage gameMessage = new GameMessage();
    private InputMessage inputMessage = new InputMessage();
    private User user = new User();
    private Computer computer = new Computer();

    public void playGame() {
        gameMessage.startGame();
        computer.throwTheBall();
        inputMessage.inputNumber();
        user.hitTheBall();
    }
}
