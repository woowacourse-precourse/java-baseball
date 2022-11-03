package baseball;

import baseball.game.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean isContinued = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(isContinued) {
            Game.playGame();
            isContinued = Game.isGameContinued();
        }
    }
}
