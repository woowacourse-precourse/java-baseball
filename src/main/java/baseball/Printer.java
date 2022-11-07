package baseball;

import static baseball.Const.BALL;
import static baseball.Const.CORRECT_ALL_NUMBER;
import static baseball.Const.FINISH_GAME;
import static baseball.Const.INPUT_NUMBER;
import static baseball.Const.LF;
import static baseball.Const.NOTHING;
import static baseball.Const.RESTART_OR_FINISH;
import static baseball.Const.START_GAME;
import static baseball.Const.STRIKE;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Printer {

    private static final BufferedWriter bufferedWriter;

    static {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void start() {
        println(START_GAME);
    }

    public static void finish() {
        println(FINISH_GAME);
    }

    public static void inputNumber() {
        print(INPUT_NUMBER);
    }

    public static void getScore(int ballCount, int strikeCount) {
        String message;
        if (strikeCount == 0 && ballCount == 0) {
            message = NOTHING;
        } else if (strikeCount == 0 && ballCount > 0) {
            message = ballCount + BALL;
        } else if (strikeCount > 0 && ballCount == 0) {
            message = strikeCount + STRIKE;
        } else {
            message = ballCount + BALL + " " + strikeCount + STRIKE;
        }
        println(message);
    }

    public static void correctAllNumber() {
        println(CORRECT_ALL_NUMBER);
    }

    public static void restartOrFinish() {
        println(RESTART_OR_FINISH);
    }

    private static void print(String s) {
        try {
            bufferedWriter.write(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void println(String s) {
        try {
            bufferedWriter.write(s);
            bufferedWriter.write(LF);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
