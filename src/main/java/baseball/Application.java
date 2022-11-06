package baseball;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new Computer(),
                             new Player(),
                             new Referee());
        game.startGame();
    }
}
