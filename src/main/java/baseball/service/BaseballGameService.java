package baseball.service;

import baseball.domain.baseball.Baseballs;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameService {
    public void run() {
        InputView inputView = new InputView();

        Baseballs computerBaseballs = Baseballs.random();
        OutputView.gameStartMessage();
        OutputView.inputNumberMessage();
        Baseballs.valueOf(inputView.input());
    }
}
