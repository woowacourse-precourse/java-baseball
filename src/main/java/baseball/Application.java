package baseball;

import baseball.service.Game;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        View.printStart();
        Game.start();
    }
}
