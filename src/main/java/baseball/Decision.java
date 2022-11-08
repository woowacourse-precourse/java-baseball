package baseball;

import java.util.HashMap;

import static baseball.ConstValue.*;

public class Decision {

    public static boolean out = false;
    private static boolean playing = true;

    public static void call() {
        //Score score = new Score();
        Score.makeScore();
        if (Score.threeStrikeOut()) {
            Message.onlyStrikeCount();
            out();
            return;
        }
        if (Score.ballAndStrikeCount()) {
            Message.ballAndStrikeCount();
            return;
        }
        if (Score.onlyBallCount()) {
            Message.onlyBallCount();
            return;
        }
        if (Score.onlyStrikeCount()) {
            Message.onlyStrikeCount();
            return;
        }
        Message.notThing();
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
