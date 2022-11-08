package baseball;

import baseball.gameController.Game;
import baseball.gameController.view.GameView;
import baseball.utils.appConfig.AppConfig;

public class Application {
    public static void main(String[] args) {
        Game game = AppConfig.createGame();
        GameView.printGameStart();
        game.play();
    }
}
