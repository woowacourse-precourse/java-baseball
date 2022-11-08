package baseball;

import baseball.exception.Exception;
import baseball.util.Util;

public class Application {
    public static void main(String[] args) {
        Exception exception = new Exception();
        Game game = new Game();
        Util util = new Util();
        do {
            game.startGame(exception);
        } while (util.continueGame(exception) != 2);
    }
}
