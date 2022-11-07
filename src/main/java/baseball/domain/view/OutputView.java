package baseball.domain.view;

import baseball.domain.util.TypeConverter;
import baseball.domain.util.Util;

import static baseball.domain.util.OutputNumbersConstants.*;

public class OutputView {
    public static final String startGame = START_GAME;
    public static final String endGame = END_GAME;
    public static final String restartGame = RESTART_GAME;

    public static void printStart() {
        System.out.println(startGame);
    }

    public static boolean printResult(int strike, int ball) {
        String answer;

        if (ball > 0 && strike > 0) answer = ball + BALL + EMPTY_STRING + strike + STRIKE;
        else {
            if (ball > 0) answer = ball + BALL;
            else if (strike > 0) answer = strike + STRIKE;
            else answer = NOTHING;
        }

        System.out.println(answer);

        return strike == 3;
    }

    public static void printEnd() {
        System.out.println(endGame);
    }

    public static int printRestart() {
        System.out.println(restartGame);
        return TypeConverter.stringToInt(Util.input());
    }
}
