package baseball;

import baseball.game.Game;
import baseball.game.GameStatus;
import util.RandomNumber;

public class Application {
    public static void main(String[] args) {
        GameStatus gameStatus = GameStatus.PROGRESSING;

        while (gameStatus.isProgressing()) {
            Game game = new Game();
            gameStatus = game.play(RandomNumber.getRandom3Numbers());
        }
    }
}
