package baseball;

import baseball.game.Game;
import baseball.utils.appConfig.AppConfig;

public class Application {
    public static void main(String[] args) {
        Game game = AppConfig.createGame();
        game.play();
    }
}
