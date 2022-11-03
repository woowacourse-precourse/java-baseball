package baseball;

import baseball.appconfig.AppConfig;
import baseball.manager.Manager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();

        Manager manager = appConfig.manager();
        manager.printGameStart();
    }
}
