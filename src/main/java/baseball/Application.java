package baseball;

import baseball.controller.BaseBallGameController;
import baseball.service.BallCountService;
import baseball.util.Constant;
import baseball.view.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallGameController(new BallCountService()));
        baseBallGame.start();   // 게임 시작
    }
}
