package baseball;

import static baseball.Constant.*;

public class PrintMessage {

    public static void gameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void gameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void enterNumber() {
        System.out.print(PLEASE_ENTER_NUMBERS);
    }

    public static void chooseRestartOrQuitGame() {
        System.out.println(CHOOSE_TO_START_OR_QUIT_GAME);
    }

    public static void onlyBallCount() {
        System.out.printf(ONLY_BALL, Score.total().get(BALL));
    }

    public static void onlyStrikeCount() {
        System.out.printf(ONLY_STRIKE, Score.total().get(STRIKE));
    }

    public static void ballAndStrikeCount() {
        System.out.printf(BALL_AND_STRIKE, Score.total().get(BALL), Score.total().get(STRIKE));
        //System.out.println(Score.total().get(BALL) + BALL + " " + Score.total().get(STRIKE) + STRIKE);
    }

    public static void notThing() {
        System.out.println(NOT_THING);
    }
}
