package baseball;

import baseball.objects.Game;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View.start();
        boolean isRestart;
        do {
            Game game = new Game();
            isRestart = game.start();

        } while (isRestart);
    }
}
