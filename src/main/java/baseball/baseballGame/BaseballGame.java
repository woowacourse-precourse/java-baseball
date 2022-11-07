package baseball.baseballGame;

import baseball.computer.Controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static baseball.baseballGame.Message.*;
import static baseball.baseballGame.Result.getResult;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String STOP = "2";

    private final int ball = 0;
    private final int strike = 1;

    private final int BALL_COUNT;

    public BaseballGame(int BALL_COUNT) {
        this.BALL_COUNT = BALL_COUNT;
    }

    public void play() {
        printStartMessage();
        do {
            runGame();
        } while (getAndCheckStatus());
    }

    public void runGame() {
        int[] balls = new Controller(BALL_COUNT).getBalls();
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
        if (inputException(input)) {
            throw new IllegalArgumentException("형식에 맞지 않음");
        }
        if (inputDuplicateException(input)) {
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
            if (Objects.equals(statusInput, RESTART)) return true;
            if (Objects.equals(statusInput, STOP)) return false;
        }
    }

    public Boolean inputException(String input) {
        if (input.length() != BALL_COUNT) {
            return true;
        }
        boolean isNumeric = input.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric) {
            return true;
        }
        return false;
    }

    public Boolean inputDuplicateException(String input) {
        String[] inputArr = input.split("");
        Set<String> duplicate = new HashSet<>(Arrays.asList(inputArr));
        if (duplicate.size() == BALL_COUNT) {
            return false;
        }
        return true;
    }
}
