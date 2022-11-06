package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static Message message;

    public static void main(String[] args) {
        startGame();
    }

    static void startGame() {
        message = new Message();
        message.startGameMessage();
    }
}
