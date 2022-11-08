package baseball;

import baseball.controller.BaseballGameBoard;

public class Application {
    public static void main(String[] args) {
        BaseballGameBoard game = new BaseballGameBoard();
        game.playTheGame();
    }
}
