package baseball;

import baseball.controller.GameController;

public class Application {

    public static void main(String[] args) {

        GameController gameController = new GameController();

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            gameController.startNewGame();
            if (!gameController.restart()) {
                break;
            }
        }
        System.out.println("게임 종료");
    }
}
