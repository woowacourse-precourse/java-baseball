package baseball;

import static baseball.Computer.NUM_LIMIT_LENGTH;
import static baseball.Computer.createRandomNumbers;
import static baseball.Message.*;
import static baseball.Player.toIntegerUserInput;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    private List<Integer> userNumber = new ArrayList<>(NUM_LIMIT_LENGTH);
    private List<Integer> computerNumber = new ArrayList<>(NUM_LIMIT_LENGTH);
    private int strike;
    private int ball;

    public BaseballGame() {
        for (int i : createRandomNumbers()) {
            computerNumber.add(i);
        }
        this.strike = 0;
        this.ball = 0;
    }

    public void start() {
        System.out.println(START_GAME);
        System.out.print(INPUT_NUM);
        String userInput = readLine();
        userNumber = toIntegerUserInput(userInput);
        checkInputData(userNumber);
        strike = checkStrikeCount(userNumber);
        ball = checkBallCount(userNumber);
        gameResult();
    }

    private void checkInputData(List<Integer> userNumber) {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다. 다시 입력해주세요.");
        }
        if (userNumber.contains(0)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만을 입력할 수 있습니다. 다시 입력해주세요");
        }
        Set<Integer> duplicate = new HashSet<>(userNumber);
        if (duplicate.size() != userNumber.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있어서는 안됩니다. 서로 다른 숫자로 다시 입력해주세요.");
        }
    }

    public int checkStrikeCount(List<Integer> userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < NUM_LIMIT_LENGTH; i++) {
            if (computerNumber.indexOf(userNumber.get(i)) == i) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int checkBallCount(List<Integer> userNumber) {
        int ballCount = 0;
        for (int i = 0; i < NUM_LIMIT_LENGTH; i++) {
            if (computerNumber.contains(userNumber.get(i)) && computerNumber.indexOf(userNumber.get(i)) != i) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public void gameResult() {
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 & strike == 0) {
            System.out.println("낫싱");
        }
    }

    public boolean endGame() {
        if (strike == 3) {
            System.out.println(USER_WIN);
            System.out.println(ASK_MESSAGE);

            String ask = readLine();
            if (ask.equals("1")) {
                return true;
            } else if (ask.equals("2")) {
                System.out.println(END_GAME);
                return false;
            } else {
                throw new IllegalArgumentException(INPUT_ONE_OR_TWO);
            }
        }
        return true;
    }
}
