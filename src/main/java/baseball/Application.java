package baseball;

import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame baseballgame = new BaseballGame();
        baseballgame.StartGame();

    }
}
