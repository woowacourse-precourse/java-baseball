package baseball;

import java.util.HashMap;

import static baseball.Constant.*;

public class Decision {

    public static boolean out = false;
    private static boolean playing = true;
    private static HashMap<String, Integer> scoreBoard;

    public static void call() {
        scoreBoard = Score.total();

        if (threeStrikeOut()) {
            Message.onlyStrikeCount();
            out();
            return;
        }
        if (ballAndStrikeCount()) {
            Message.ballAndStrikeCount();
            return;
        }
        if (onlyBallCount()) {
            Message.onlyBallCount();
            return;
        }
        if (onlyStrikeCount()) {
            Message.onlyStrikeCount();
            return;
        }
        Message.notThing();
    }

    private static boolean threeStrikeOut() {
        return scoreBoard.get(STRIKE).equals(THREE_STRIKE_OUT);
    }

    private static boolean onlyBallCount() {
        return !scoreBoard.get(BALL).equals(NO_COUNT) && scoreBoard.get(STRIKE).equals(NO_COUNT);
    }

    private static boolean onlyStrikeCount() {
        return scoreBoard.get(BALL).equals(NO_COUNT) && !scoreBoard.get(STRIKE).equals(NO_COUNT);
    }

    private static boolean ballAndStrikeCount() {
        return !scoreBoard.get(BALL).equals(NO_COUNT) && !scoreBoard.get(STRIKE).equals(NO_COUNT);
    }

    private static void out() {
        Message.gameEnd();
        out = true;
    }

    public static void reStart() {
        playing = true;
        out = false;
    }

    public static void newGame() {
        playing = true;
    }
    public static boolean isPlaying() {
        return playing;
    }
    public static void quitGame() {
        playing = false;
    }
}
