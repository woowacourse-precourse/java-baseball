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
        System.out.println(Score.getBall()+BALL);
    }

    public static void onlyStrikeCount() {
        System.out.println(Score.getStrike()+STRIKE);
    }

    public static void ballAndStrikeCount() {
        System.out.println(Score.getBall()+BALL+" "+Score.getStrike()+STRIKE);
    }

    public static void notThing() {
        System.out.println(NOT_THING);
    }
}
