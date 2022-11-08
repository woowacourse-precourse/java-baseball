package baseball.view;

import baseball.domain.Game;

import static baseball.view.OutputMessage.*;

public class OutputView {

    public static void printInit() {
        System.out.println(INIT_GAME.message());
    }

    public static void printInput() {
        System.out.println(INPUT_NUMBER.message());
    }

    public static void printFinish() {
        System.out.println(EXIT_GAME.message());
    }

    public static void printRestart() {
        System.out.println(INPUT_RESTART_OR_EXIT.message());
    }

    public static void printGameResult(Game game) {
        System.out.println(game);
    }
}
