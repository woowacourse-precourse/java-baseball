package baseball;

import baseball.game.Game;
import baseball.io.IOTopClass;

public class Application {

    private static final int NUM_LENGTH = 3;

    public static void main(String[] args) {
        IOTopClass ioTopClass = new IOTopClass(NUM_LENGTH);
        Game game = new Game(NUM_LENGTH);
        game.runGame(ioTopClass);
    }
}
