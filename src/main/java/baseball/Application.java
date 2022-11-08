package baseball;

import baseball.config.BaseballConfig;

public class Application {

    public static void main(String[] args) {
        BaseballConfig.config().play();
    }
}
