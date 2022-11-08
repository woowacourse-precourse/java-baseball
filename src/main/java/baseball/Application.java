package baseball;

import baseball.model.Computer;
import baseball.model.Player;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new Computer(),
                             new Player());
        game.startGame();
    }
}
