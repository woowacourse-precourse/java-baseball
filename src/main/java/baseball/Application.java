package baseball;

import baseball.game.Game;
import baseball.io.IOTopClass;

public class Application {

    private static final int LIST_SIZE = 3;
    public static void main(String[] args) {
        IOTopClass ioTopClass = new IOTopClass(LIST_SIZE);
        Game game = new Game(LIST_SIZE);
        game.runGame(ioTopClass);
    }
}
