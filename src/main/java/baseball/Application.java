package baseball;

import baseball.game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        while (!game.isEnd()) {
            game.start();
            game.play();
            game.pause();
        }
    }
}
