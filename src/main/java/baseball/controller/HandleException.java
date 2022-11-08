package baseball.controller;

import java.io.IOException;

public class HandleException {

    public void handleUserInputNumberRangeException(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) < 48 || userInput.charAt(i) > 57) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임을 종료합니다.");
            }
        }
    }

    static void handleUserInputDuplicationException(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (i != userInput.indexOf(userInput.charAt(i))) {
                throw new IllegalArgumentException("중복된 값을 입력하였습니다. 게임을 종료합니다.");
            }
        }
    }

    public void handleUserInputSizeException(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력하지 않았습니다. 게임을 종료합니다.");
        }
    }

    public void handleRestartOrExitNumberException(int restartORExit) {
        if (1 > restartORExit || restartORExit > 2) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임을 종료합니다.");
        }
    }
}
