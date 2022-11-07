package baseball.controller;

import baseball.service.BaseballGameInputService;
import baseball.service.BaseballGameService;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    BaseballGameService baseballGameService = new BaseballGameService();
    BaseballGameInputService baseballGameInputService = new BaseballGameInputService();
    BaseballGameView baseballGameView = new BaseballGameView();

    public void gameIntro() {
        baseballGameView.gameIntroMessage();
    }

    public void gameStart() {
        
    }

}
