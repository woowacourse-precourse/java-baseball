package baseball;

import baseball.model.Game;
import baseball.util.GameCode;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Game game=Game.start();

        while (game.getStatus()== GameCode.PLAY.getValue()){
            game.play();
        }
    }
}
