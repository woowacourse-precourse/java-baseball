package baseball;

import baseball.computer.Controller;

import java.util.Objects;
import java.util.stream.Stream;

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
        } while (checkStatus());
    }

    public void runGame() {
        int[] balls = new Controller().getBalls();
        int[] result;
        do {
            printInputMessage();
            int[] userBalls = stringToArray(getUserBalls());
            result = getResult(balls, userBalls);
            printResultMessage(result[ball],result[strike]);
        } while (checkResult(result));
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
        return input;
    }

    public int[] stringToArray(String input) {
        return Stream.of(String.valueOf(input).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public Boolean checkResult(int[] result){
        if (result[strike]==3){
            return false;
        }
        return true;
    }

    public Boolean checkStatus() {
        while (true) {
            printRestartMessage();
            String statusInput = getInput();
            if (Objects.equals(statusInput, RE_GAME)) return true;
            if (Objects.equals(statusInput, STOP_GAME)) return false;
        }
    }

    public Boolean checkInputException(String input) {
        // 길이가 3이 아닐 경우
        if (input.length() != 3) {
            return true;
        }
        // 모두 숫자가 아닐 경우
        boolean isNumeric = input.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric) {
            return true;
        }
        return false;
    }

}
