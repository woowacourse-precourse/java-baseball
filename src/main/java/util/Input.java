package util;

import baseball.game.GameStatus;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private static final String SPACE = "";

    public static String readLine() {
        return Console.readLine();
    }

    public static List<Integer> makeListFromInput() {
        return makeListFromInput(readLine());
    }

    public static GameStatus readLineAfterGame() {
        return readLineAfterGame(readLine());
    }

    protected static GameStatus readLineAfterGame(String readLine) {
        validateInputNum(readLine);

        if (readLine.equals(RESTART)) {
            return GameStatus.PROGRESSING;
        }
        return GameStatus.EXIT;
    }

    private static void validateInputNum(String readLine) {
        if (isContainCorrectAnswer(readLine)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isContainCorrectAnswer(String readLine) {
        return !(readLine.equals(RESTART) || readLine.equals(EXIT));
    }

    protected static List<Integer> makeListFromInput(String readLine) {
        String[] splitFromInput = readLine.split(SPACE);

        return Arrays.stream(splitFromInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
