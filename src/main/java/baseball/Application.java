package baseball;

import baseball.domain.Game;
import baseball.domain.Player;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);

        while (player.wantNewGame()) {
            game.run();
        }
    }
}
