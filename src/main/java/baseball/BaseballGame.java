package baseball;

import baseball.computer.Controller;
import java.util.List;

public class BaseballGame {
    private static final int RE_GAME = 1;
    private static final int STOP_GAME = 2;

    public static void baseballGame() {
        List<Integer> balls = new Controller().makeBalls();
    }
}
