package baseball;

import baseball.constant.Message;
import baseball.entity.Game;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();

        System.out.println(Message.START_MESSAGE);

        while (!game.stopGame()) {
            game.init();
            game.start();
        }

    }
}
