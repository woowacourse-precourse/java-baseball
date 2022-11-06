package baseball.domain;

import baseball.util.Input;

import java.util.List;

public class User {

    public User() {
    }

    public List<String> inputUserAnswer() {
        return Input.inputNumber();
    }

    public String replay() {
        return Input.inputReplayAnswer();
    }

}
