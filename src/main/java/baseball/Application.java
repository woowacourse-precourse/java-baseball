package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.*;

public class Application {
    public static void main(String[] args) {
        do {
            Game.playGame();
        } while (restartGame());
    }
    public static boolean restartGame() {
        System.out.println(RESTART_MESSAGE);
        String s = Console.readLine();
        if (s.equals(RESTART_GAME)) {
            return true;
        } else if (s.equals(QUIT_APP)) {
            return false;
        } else {
            throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
        }
    }
}
