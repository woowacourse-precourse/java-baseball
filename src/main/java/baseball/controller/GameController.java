package baseball.controller;

import baseball.BaseballScore;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameMessage;
import baseball.view.InputMessage;
import java.util.Map;

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
        Map<BaseballScore, Integer> resultScore;

        inputMessage.inputNumber();
        user.hitTheBall();

        resultScore = computer.compare(user.getBat());
        gameMessage.printGameResult(resultScore);
    }

}
