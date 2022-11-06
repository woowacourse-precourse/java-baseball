package baseball;

import baseball.computer.Controller;

import static baseball.Result.*;
import static camp.nextstep.edu.missionutils.Console.*;
import static baseball.Message.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseballGame {
    private static final String RE_GAME = "1";
    private static final String STOP_GAME = "2";

    public void play() {
        printStartMessage();
        do {
            Boolean doneGame = runGame();
            if (!doneGame) {
                return;
            }
        } while (checkStatus());
    }

    public Boolean runGame() {
        List<Integer> balls = new Controller().getBalls();
        boolean status = true;
        do {
            printInputMessage();
            String input;
            try {
                input = getBalls();
            } catch (IllegalArgumentException e) {
                // 종료 메세지 출력
                return false;
            }
            int[] userBalls = stringToArray(input);
            status = getResult(balls, userBalls);
            //값 비교
        } while (status);
        printFinishMessage();
        return true;
    }

    public String getInput() {
        return readLine();
    }

    public String getBalls() throws IllegalArgumentException {
        String input = getInput();
        if (checkInputException(input)) {
            throw new IllegalArgumentException("형식에 맞지 않음");
        }
        return input;
    }

    public int[] stringToArray(String input) {
        return Stream.of(input).mapToInt(Integer::parseInt).toArray();
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
