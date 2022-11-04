package baseball;

import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView game = new GameView();
        game.run();
    }
}
