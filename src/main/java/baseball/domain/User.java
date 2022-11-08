package baseball.domain;

import baseball.util.Input;

import java.util.List;

public class User {

    List<String> userAnswer;
    String userReplayAnswer;

    public List<String> getUserAnswer() {
        inputUserAnswer();
        return userAnswer;
    }

    private void inputUserAnswer() {
        userAnswer = Input.inputNumber();
    }

    public String getUserReplayAnswer() {
        inputUserReplayAnswer();
        return userReplayAnswer;
    }

    private void inputUserReplayAnswer() {
        userReplayAnswer = Input.inputReplayAnswer();
    }

}
