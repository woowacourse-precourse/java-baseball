package baseball.view;

import baseball.domain.Result;

import static baseball.constant.Constants.*;

public class View {

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameClear() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(GAME_FINISH_MESSAGE);
        System.out.println(RESTART_OR_QUIT_MESSAGE);
    }

    public static void printInputGuide() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printResult(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        if (ballCount != 0) {
            System.out.print(ballCount+BALL);
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount+STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }
}
