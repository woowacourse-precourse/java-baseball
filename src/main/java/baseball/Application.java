package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        boolean checkGame;

        System.out.println("숫자 야구 게임을 시작합니다.");
        gameController.startGame();

        while (true) {
            checkGame = gameController.checkGame();

            if (!checkGame) {
                break;
            }

        }
    }

}
