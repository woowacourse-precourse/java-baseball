package baseball;

import baseball.constant.Message;
import baseball.entity.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Game game = new Game();

        System.out.println(Message.START_MESSAGE);

        while(game.checkStopGame()) {
            game.init();
            game.start();
        }

    }
}
