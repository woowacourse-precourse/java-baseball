package baseball;

import baseball.computer.Controller;

import java.util.*;
import java.util.stream.Stream;

import static baseball.AppConfig.BALL_COUNT;
import static baseball.Message.*;
import static baseball.Result.getResult;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private static final String RE_GAME = "1";
    private static final String STOP_GAME = "2";
    private static final int ball = 0;
    private static final int strike = 1;

    public void play() {
        printStartMessage();
        do {
            runGame();
        } while (getAndCheckStatus());
    }

    public void runGame() {
        int[] balls = new Controller().getBalls();
        int[] result;
        do {
            printInputMessage();
            int[] userBalls = stringToArray(getUserBalls());
            result = getResult(balls, userBalls);
            printResultMessage(result[ball], result[strike]);
        } while (!correct(result));
        printFinishMessage();
    }

    public String getInput() {
        return readLine();
    }

    public String getUserBalls() throws IllegalArgumentException {
        String input = getInput();
        if (checkInputException(input)) {
            throw new IllegalArgumentException("형식에 맞지 않음");
        }
        if (checkInputDuplicateException(input)) {
            throw new IllegalArgumentException("중복 값 포함 됨");
        }
        return input;
    }

    public int[] stringToArray(String input) {
        return Stream.of(String.valueOf(input).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public Boolean correct(int[] result) {
        return result[strike] == BALL_COUNT;
    }

    public Boolean getAndCheckStatus() {
        while (true) {
            printRestartMessage();
            String statusInput = getInput();
            if (Objects.equals(statusInput, RE_GAME)) return true;
            if (Objects.equals(statusInput, STOP_GAME)) return false;
        }
    }

    public Boolean checkInputException(String input) {
        if (input.length() != BALL_COUNT) {
            return true;
        }
        boolean isNumeric = input.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric) {
            return true;
        }
        return false;
    }

    public Boolean checkInputDuplicateException(String input) {
        String[] inputArr = input.split("");
        Set<String> duplicate = new HashSet<>(Arrays.asList(inputArr));
        if (duplicate.size() == BALL_COUNT) {
            return false;
        }
        return true;
    }
}
