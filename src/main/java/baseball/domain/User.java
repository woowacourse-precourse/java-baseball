package baseball.domain;

import baseball.view.InputView;

public class User {
    private BaseballNumbers baseballNumbers; // user 입력값
    private int restartOrStop;

    public void inputBaseballNumbers(){
        baseballNumbers = InputView.inputBaseballNumbers();
    }

}
