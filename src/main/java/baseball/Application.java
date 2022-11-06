package baseball;

import baseball.mainframe.Game;
import baseball.view.GameOutput;

public class Application {
    public static void main(String[] args) {
        Game baseballGame = new Game();
        GameOutput.printStartGame();
        baseballGame.start();
    }
}
