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
            throwBall();
            player.ballCount(goal.getGoalNumber());
            message.ballCountMessage(player.getBall(), player.getStrike());
        } while (!strikeOut());
        message.endGameMessage();
    }

    static void throwBall() {
        message.inputNumberMessage();
        String inputNumber = Console.readLine();

        player = new Player();
        player.setPlayerNumber(inputNumber);
    }

    static boolean strikeOut() {
        if (player.getStrike() == 3) {
            return true;
        }
        return false;
    }
}
