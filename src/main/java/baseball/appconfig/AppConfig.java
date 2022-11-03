package baseball.appconfig;

import baseball.manager.Manager;
import baseball.manager.NumberBaseballManager;

public class AppConfig {
    public Manager manager() {
        return new NumberBaseballManager();
    }
}
