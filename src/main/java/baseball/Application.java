package baseball;

import baseball.game.Game;
import baseball.io.IOTopClass;

public class Application {

    public static void main(String[] args) {
        IOTopClass ioTopClass = new IOTopClass(3);
        Game game = new Game();
        game.runGame(ioTopClass);
    }
}
