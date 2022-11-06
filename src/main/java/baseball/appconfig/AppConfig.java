package baseball.appconfig;

import baseball.computer.Computer;
import baseball.computer.NumberBaseballComputer;
import baseball.manager.Manager;
import baseball.manager.NumberBaseballManager;

public class AppConfig {

    public Manager manager() {
        return new NumberBaseballManager();
    }

    public Computer computer() {
        return new NumberBaseballComputer();
    }
}
