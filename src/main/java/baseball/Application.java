package baseball;

import baseball.util.Constant;
import baseball.view.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Constant.START_MESSAGE);
        BaseBallGame baseBallGame = new BaseBallGame();
        do {
            // TODO: 게임 시작
            baseBallGame.start();
        } while (baseBallGame.isRestart());
    }
}
