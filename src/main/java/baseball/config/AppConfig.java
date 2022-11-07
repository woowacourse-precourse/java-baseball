package baseball.config;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.Validator;
import baseball.view.Input;

public class AppConfig {
    public Input input() {
        return new Input(validator());
    }

    private static Validator validator() {
        return new Validator();
    }

    public Referee referee() {
        return new Referee(computer());
    }

    private static Computer computer() {
        return new Computer();
    }

}
