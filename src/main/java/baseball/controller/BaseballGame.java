package baseball.controller;

public class BaseballGame {

    public void playTheGame() {
        do {
            startGame();
        } while (!exit());
    }

    private static void startGame() {

    }

    private static boolean exit() {
        return true;
    }
}
