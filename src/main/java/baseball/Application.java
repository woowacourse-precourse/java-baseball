package baseball;

import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startGame();
        while (baseballGame.isGameContinue()) {
            baseballGame.startRound();
            baseballGame.quitGameOrNot();
        }
    }
}
