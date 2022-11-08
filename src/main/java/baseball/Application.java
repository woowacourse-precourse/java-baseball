package baseball;

import baseball.controller.BaseBallGame;
import baseball.util.Message;

public class Application {
    public static void main(String[] args) {
        System.out.println(Message.GAME_START_MESSAGE);
        BaseBallGame baseBallGame = new BaseBallGame();

        baseBallGame.start();
    }
}
