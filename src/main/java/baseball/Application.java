package baseball;

import baseball.game.Controller;

public class Application {
    public static void main(String[] args) {
        Controller game = new Controller();
        game.run();
    }
}
