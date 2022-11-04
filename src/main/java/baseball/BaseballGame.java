package baseball;

import baseball.computer.Controller;

import static camp.nextstep.edu.missionutils.Console.*;
import static baseball.Message.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseballGame extends Message {
    private static final String RE_GAME = "1";
    private static final String STOP_GAME = "2";

    public void play() {
        printStartMessage();
        String statusInput;
        do {
            runGame();
            printRestartMessage();
            statusInput = getStatusInput();
        } while (Objects.equals(statusInput, RE_GAME));
    }

    public void runGame() {
        List<Integer> balls = new Controller().getBalls();
        do {
            printInputMessage();
            String input;
            try {
                input = getInput();
            } catch (IllegalArgumentException e) {
                return;
            }
            int[] userBalls = getUserBalls(input);
            //값 비교
        } while (true);
        // 모두 맞출때까지
    }

    public String getInput() throws IllegalArgumentException {
        String input = readLine();
        if (checkInputException(input)) {
            throw new IllegalArgumentException("형식에 맞지 않음");
        }
        return input;
    }

    public String getStatusInput(){
        return readLine();
    }

    public int[] getUserBalls(String input) {
        return Stream.of(input).mapToInt(Integer::parseInt).toArray();
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
