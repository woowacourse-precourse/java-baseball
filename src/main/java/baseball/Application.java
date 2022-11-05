package baseball;

import baseball.application.BaseBallApplication;
import baseball.application.config.BaseBallGameConfig;

public class Application {
    public static void main(String[] args) {
        BaseBallGameConfig config = new BaseBallGameConfig();

        BaseBallApplication baseBallApplication = new BaseBallApplication(config);

        baseBallApplication.play();
    }
}
