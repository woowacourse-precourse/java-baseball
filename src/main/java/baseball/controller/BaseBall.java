package baseball.controller;

import baseball.dto.UserNumbersDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBall {
    public void start() {
        OutputView.printApplicationStartMessage();
        
        final UserNumbersDTO userNumbersDTO = InputView.inputUserBalls();
    }
}
