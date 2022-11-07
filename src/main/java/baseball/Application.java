package baseball;

import baseball.domain.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = BaseballGame.init();
        game.start();
    }
}
