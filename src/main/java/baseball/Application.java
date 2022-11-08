package baseball;

import game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        try {
            access();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private static void access() throws IllegalArgumentException {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
    }
}
