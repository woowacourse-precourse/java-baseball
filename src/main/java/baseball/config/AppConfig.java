package baseball.config;

import baseball.controller.ComputerController;
import baseball.controller.PlayerController;
import baseball.controller.RefereeController;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.RefereeService;

public class AppConfig {
    public ComputerController computerController() {
        return new ComputerController(new ComputerService());
    }

    public PlayerController playerController() {
        return new PlayerController(new PlayerService());
    }

    public RefereeController refereeController() {
        return new RefereeController(new RefereeService());
    }
}
