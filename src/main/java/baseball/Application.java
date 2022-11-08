package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        GameController gameController = new GameController();
        gameController.initGame();

        while (true) {
            gameController.startGame();

            if(gameController.isWin() && !gameController.restart())
                break;
        }
    }
}
