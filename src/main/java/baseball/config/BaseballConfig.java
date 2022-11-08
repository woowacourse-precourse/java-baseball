package baseball.config;

import baseball.controller.BaseballController;
import baseball.service.BaseballServiceImpl;
import baseball.validation.BaseballInputValidator;

public class BaseballConfig {

    public static BaseballController config() {
        return new BaseballController(new BaseballServiceImpl(), new BaseballInputValidator());
    }
}
