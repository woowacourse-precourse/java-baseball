package baseball.domain;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private BaseballNumbers baseballNumbers; // user 입력값
    private int restartOrStop;

    public void inputBaseballNumbers(){
        baseballNumbers = InputView.inputBaseballNumbers();
    }

    public BaseballNumbers getBaseballNumbers() {
        return baseballNumbers;
    }

    public void inputRestartOrStop() {
        this.restartOrStop = InputView.inputUserRestartOrStop();
    }

    public int getRestartOrStop() {
        return restartOrStop;
    }
}
