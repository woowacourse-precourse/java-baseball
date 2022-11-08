package baseball;

import java.util.*;

import static baseball.Function.*;
import static baseball.Sentence.*;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    protected static List<Integer> Answer;
    protected static String ResponseOfRestart;

    public Player() {
    }

    public static void resetAll() {
        Answer = new ArrayList<>();
        ResponseOfRestart = BLANK;
    }

    public static void isValidAnswer(String input) {
        if (input.length() != 3 || !isInteger(input) || !isPositiveNumber(input)
                || !isDifferentNumbers(changeStringtoList(input))) {
            throw new IllegalArgumentException(GAMEOVER);
        }
    }

    public static void guessAnswer() {
        System.out.print(PLEASE_INPUT_NUMBER);
        String input = Console.readLine();
        isValidAnswer(input);
        Answer = changeStringtoList(input);
    }

    public static void responseRestart() {
        ResponseOfRestart = Console.readLine();
        if (!ResponseOfRestart.equals(OK) && !ResponseOfRestart.equals(NO)) {
            throw new IllegalArgumentException(GAMEOVER);
        }
    }

}
