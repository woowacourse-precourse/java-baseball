package baseball;

import baseball.global.config.AppConfig;
import baseball.presentation.BaseBallGameController;

public class Application {
    public static void main(String[] args) {
        final AppConfig appConfig = new AppConfig();
        final BaseBallGameController gameController = appConfig.gameController();

        boolean isContinue;
        do {
            isContinue = gameController.baseballGame();
        } while (isContinue);
    }
}
