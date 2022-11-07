package baseball;

import baseball.game.BaseballGame;
import baseball.util.InputController;
import baseball.util.Logger;
import baseball.util.RandomGenerator;

public class Application {

    private static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        playBaseballGame();
    }

    private static void playBaseballGame() {
        boolean isFirstGame = true;
        Logger.log(BaseballGame.getStartMessage() + '\n');

        while (true) {
            if (isFirstGame) {
                newBaseballGame();
                isFirstGame = false;
            }

            Logger.log(RESTART_OR_EXIT_MESSAGE + '\n');
            Integer selectNumber = InputController.getOneNumber();

            if (selectNumber.equals(2)) {
                break;
            }
            newBaseballGame();
        }
    }

    private static void newBaseballGame() {
        BaseballGame baseballGame = new BaseballGame(RandomGenerator.genNumberList(3));
        baseballGame.play();
    }
}
