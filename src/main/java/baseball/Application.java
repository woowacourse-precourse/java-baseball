package baseball;

import baseball.game.Computer;
import baseball.game.Game;
import baseball.game.User;

public class Application {
    public static void main(String[] args) {
        Game game = Game.create(new Computer(), new User());
        game.start();
    }
}
