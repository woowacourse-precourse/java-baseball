package baseball;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        Computer computer = new Computer();
        User user = new User();

        game.turnOnGame(computer, user);

        do {
            game.startNewGame();
        } while (game.replayGame());

    }
}
