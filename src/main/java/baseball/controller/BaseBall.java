package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBall {
    public void start() {
        OutputView.printApplicationStartMessage();
        InputView.printNumberInputPrompt();
    }
}
