package baseball;

import static baseball.Constant.*;

public class GameSituation {
    public static void printStart() {
        System.out.println(GAME_START);
    }

    public static void printFinish() {
        System.out.println(GAME_FINISH);
    }

    public static void printRetry() {
        System.out.println(OPTION);
    }

    public static void printHint(String hint) {
        System.out.println(hint);
    }

    public static void printCorrect() {
        System.out.print(CORRECT);
    }

    public static void printNoZero() {
        System.out.println(NO_ZERO);
    }
}
