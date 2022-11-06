package baseball;

import baseball.domain.Game;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        Game baseballGame = new Game();
        View.startView();
        baseballGame.start();
    }
}
