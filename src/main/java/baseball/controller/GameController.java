package baseball.controller;

import baseball.model.CounterpartModel;
import baseball.view.AppView;

public class GameController {
    private CounterpartModel counterpart;

    public GameController() {
        this.counterpart = new CounterpartModel();
    }

    public void run() {
        AppView.outputLine("숫자 야구 게임을 시작합니다.");

    }
}
