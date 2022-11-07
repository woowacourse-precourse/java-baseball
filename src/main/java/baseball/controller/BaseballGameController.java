package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.util.Input;
import baseball.util.Validate;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private final BaseballGameView baseballGameView;
    private BaseballGameService baseballGameService;
    private Input input;

    public BaseballGameController() {
        this.baseballGameView = new BaseballGameView();
        this.baseballGameService = new BaseballGameService();
        this.input = new Input();
    }

    public void startProgram() {
        baseballGameView.displayGameStart();
        do {
            startGame();
            readInputOfOneAndTwo();
        } while (Validate.isReStartGame(input.getUserInput()));
        //finish
    }

    private void startGame() {
        baseballGameView.displayPleaseEnterNumber();
    }

    private void readInputOfOneAndTwo() {
        input.setUserInputByRead();
    }

}
