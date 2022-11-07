package baseball.controller;

import baseball.model.CounterpartModel;
import baseball.model.ResultModel;
import baseball.view.AppView;

public class GameController {
    private CounterpartModel counterpart;

    public GameController() {
        this.counterpart = new CounterpartModel();
    }

    public int inputNumber() {
        AppView.output("숫자를 입력해주세요 : ");
        String myAnswer = AppView.inputLine();
        return Integer.parseInt(myAnswer);
    }

    public void run() {
        AppView.outputLine("숫자 야구 게임을 시작합니다.");
        boolean isAnswer = false;
        do {
            ResultModel aSetOfGame = new ResultModel();
        } while(!isAnswer);
    }
}
