package baseball.domain;

import baseball.util.Input;

import java.util.List;

public class User {

    public List<String> getUserAnswer() {
        return inputUserAnswer();
    }

    private List<String> inputUserAnswer() {
        return Input.inputNumber();
    }

    public String getUserReplayAnswer() {
        return Input.inputReplayAnswer();
    }

}
