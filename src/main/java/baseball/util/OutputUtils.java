package baseball.util;

import baseball.domain.Game;

import static baseball.util.OutputMessage.*;

public class OutputUtils {

    public static void printInitView() {
        System.out.println(INIT_GAME.message());
    }

    public static void printInputView() {
        System.out.println(INPUT_NUMBER.message());
    }

    public static void printFinishView() {
        System.out.println(EXIT_GAME.message());
    }

    public static void printRestartView() {
        System.out.println(INPUT_RESTART_OR_EXIT.message());
    }

    public static void printGameResultView(Game game) {
        System.out.println(game);
    }
}
