package baseball.domain;

import baseball.util.Input;

public class User {

    public String inputUserAnswer() {
        return Input.inputNumber();
    }

    public String replay() {
        return Input.inputReplayAnswer();
    }

}
