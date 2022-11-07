package baseball;

import baseball.engine.GameEngine;

public class Application {

    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();

        gameEngine.start();
    }
}
