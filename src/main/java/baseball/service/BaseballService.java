package baseball.service;

import static baseball.message.SystemMessage.*;

import baseball.domain.BaseballMachine;
import baseball.util.Input;

public class BaseballService {

    private BaseballMachine baseballMachine;

    public BaseballService() {
        this.baseballMachine = new BaseballMachine();
    }

    // 인사
    public void welcome() {
        System.out.println(GAME_START_MESSAGE);
    }
}
