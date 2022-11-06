package baseball.controller;

import baseball.BaseballScore;
import baseball.GameConstants;
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
        boolean gameOver = false;
        Map<BaseballScore, Integer> resultScore;

        while(!gameOver) {
            inputMessage.inputNumber();
            user.hitTheBall();

            resultScore = computer.compare(user.getBat());
            gameMessage.printGameResult(resultScore);

            gameOver = isGameOver(resultScore);
        }
    }

    public boolean isGameOver(Map<BaseballScore, Integer> resultScore) {
        int strikeCount = resultScore.get(BaseballScore.STRIKE);
        return strikeCount == GameConstants.NUMBER_LENGTH;
    }

    public void end() {
        gameMessage.endGame();

        replay();
    }

    public boolean replay() {
        inputMessage.inputReplay();
        return user.isReplayGame();
    }

}
