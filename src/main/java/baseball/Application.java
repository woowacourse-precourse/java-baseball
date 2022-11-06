package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static Goal goal;
    private static Message message;

    public static void main(String[] args) {
        startGame();
    }

    static void startGame() {
        message = new Message();
        message.startGameMessage();

        setGame();
    }

    static void setGame() {
        goal = new Goal();
        goal.setGoalNumber();
    }
}
