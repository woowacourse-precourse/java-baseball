package baseball;

import baseball.exception.Exception;

public class Application {
    public static void main(String[] args) {
        Exception exception = new Exception();
        Game game = new Game();
        do {
            game.startGame(exception);
        } while (game.continueGame(exception) != 2);
    }
}
