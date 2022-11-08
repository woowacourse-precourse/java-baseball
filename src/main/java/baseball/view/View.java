package baseball.view;

import baseball.domain.Result;

import static baseball.constant.Constants.*;

public class View {

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameFinished() {
        System.out.println(GAME_FINISH_MESSAGE);
    }

    public static void printGameClear() {
        System.out.print(SUCCESS_MESSAGE);
        System.out.println(GAME_FINISH_MESSAGE);
        System.out.println(RESTART_OR_QUIT_MESSAGE);
    }

    public static void printInputGuide() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printResult(Result result) {
        System.out.println(result.toString());
    }
}
