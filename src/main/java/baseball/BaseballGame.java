package baseball;

import static baseball.Computer.NUM_LIMIT_LENGTH;
import static baseball.Computer.createRandomNumbers;
import static baseball.Message.*;
import static baseball.Player.toIntegerPlayerInput;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    private List<Integer> PlayerNumber = new ArrayList<>(NUM_LIMIT_LENGTH);
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
        System.out.print(INPUT_NUM);
        String PlayerInput = readLine();
        PlayerNumber = toIntegerPlayerInput(PlayerInput);
        checkInputData(PlayerNumber);
        strike = checkStrikeCount(PlayerNumber);
        ball = checkBallCount(PlayerNumber);
        gameResult();
    }

    private void checkInputData(List<Integer> PlayerNumber) {
        if (PlayerNumber.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다. 다시 입력해주세요.");
        }
        if (PlayerNumber.contains(0)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만을 입력할 수 있습니다. 다시 입력해주세요");
        }
        Set<Integer> duplicate = new HashSet<>(PlayerNumber);
        if (duplicate.size() != PlayerNumber.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있어서는 안됩니다. 서로 다른 숫자로 다시 입력해주세요.");
        }
    }

    private int checkStrikeCount(List<Integer> PlayerNumber) {
        int strikeCount = 0;
        for (int i = 0; i < NUM_LIMIT_LENGTH; i++) {
            if (computerNumber.indexOf(PlayerNumber.get(i)) == i) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int checkBallCount(List<Integer> PlayerNumber) {
        int ballCount = 0;
        for (int i = 0; i < NUM_LIMIT_LENGTH; i++) {
            if (computerNumber.contains(PlayerNumber.get(i)) && computerNumber.indexOf(PlayerNumber.get(i)) != i) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private void gameResult() {
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
            System.out.println(PLAYER_WIN);
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
