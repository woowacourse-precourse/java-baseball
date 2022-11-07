package baseball.controller;

import baseball.domain.Computer;

public class BaseballController {
    private Computer computer = new Computer();

    private boolean isRightAnswer() {
        return computer.isAnswer();
    }
}
