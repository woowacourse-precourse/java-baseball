package baseball;

import baseball.Game.Game;

public class Application {
    private static final String QUIT = "2";

    public static void main(String[] args) {
        boolean isApplicationRun;
        do {
            Game.startGame();
            String input = Game.resetGameOrQuit();
            isApplicationRun = isAppRun(input);
        } while (isApplicationRun);
    }

    private static boolean isAppRun(String input) {
        if (input.equals(QUIT)) {
            return false;
        }
        return true;
    }
}