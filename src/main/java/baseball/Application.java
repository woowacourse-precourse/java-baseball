package baseball;

import baseball.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Game game = new Game(appConfig.computerController(),
                             appConfig.playerController(),
                             appConfig.refereeController());
        game.startGame();
    }
}
