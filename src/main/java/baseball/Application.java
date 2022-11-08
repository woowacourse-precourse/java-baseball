package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        System.out.println("숫자 야구 게임을 시작합니다.");
        gameController.startGame();

        String restartGameValue = "1";

        while (true) {

            if (!gameController.runningGame()) {
                restartGameValue = gameController.restartGame();

                if (restartGameValue.equals("1")) {
                    gameController.startGame();
                } else if (restartGameValue.equals("2")) {
                    break;
                }
            }
        }
    }

}
