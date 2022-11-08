package baseball;

import baseball.model.Goal;
import baseball.model.Player;
import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {

    private static Goal goal;
    private static Player player;
    private static Message message;

    static void startGame() {
        message = new Message();
        message.startGameMessage();
        do {
            setGame();
            playGame();
        } while (message.restartGameMessage());
    }

    static void setGame() {
        goal = new Goal();
        goal.setGoalNumber();
    }

    static void playGame() {
        do {
            inputNumber();
            player.ballCount(goal.getGoalNumber());
            message.ballCountMessage(player.getBall(), player.getStrike());
        } while (!player.strikeOut());
        message.endGameMessage();
    }

    static void inputNumber() {
        String playerNumber = message.inputNumberMessage();

        player = new Player();
        player.setPlayerNumber(playerNumber);
    }
}
