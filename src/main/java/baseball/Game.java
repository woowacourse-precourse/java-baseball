package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    static final int INPUT_LENGTH = 3;
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    static final String NOTHING = "낫싱";

    static final String WIN_NOTICE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String START_NOTICE = "숫자 야구 게임을 시작합니다.";
    static final String INPUT_NUMBER_NOTICE = "숫자를 입력해주세요 : ";
    static final String RESTART_OR_END_NOTICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    List<Integer> computerNumber;
    List<Integer> playerNumber;
    boolean isGameOn;
    boolean restarter;

    public List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<Integer>();
        while (computerNumber.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public List<Integer> getPlayerNumber() throws IllegalArgumentException {
        List<Integer> playerNumber = new ArrayList<Integer>();
        String input = Console.readLine();
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < input.length(); i++) {
            playerNumber.add(Integer.valueOf(String.valueOf(input.charAt(i))));
        }
        if (playerNumber.size() != playerNumber.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        return playerNumber;
    }

    public int checkBall(List<Integer> playerNumber) {
        int ballCount = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (computerNumber.contains(playerNumber.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int checkStrike(List<Integer> playerNumber) {
        int strikeCount = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int[] checkNumber(List<Integer> playerNumber) {
        int ballCount = checkBall(playerNumber);
        int strikeCount = checkStrike(playerNumber);
        ballCount -= strikeCount;
        return new int[]{ballCount, strikeCount};
    }

    public void printResult(int[] countResult) {
        if (countResult[0] == 0 && countResult[1] == 0) {
            System.out.println(NOTHING);
        } else if (countResult[0] != 0 && countResult[1] == 0) {
            System.out.println(countResult[0] + BALL);
        } else if (countResult[0] == 0 && countResult[1] != 0) {
            System.out.println(countResult[1] + STRIKE);
        } else if (countResult[0] != 0 && countResult[1] != 0) {
            System.out.println(countResult[0] + BALL + " " + countResult[1] + STRIKE);
        }
        if (countResult[1] == 3) {
            System.out.println(WIN_NOTICE);
            isGameOn = false;
        }
    }

    public void getHint() {
        System.out.print(INPUT_NUMBER_NOTICE);
        playerNumber = getPlayerNumber();
        printResult(checkNumber(playerNumber));
    }


    public void start() {
        isGameOn = true;
        computerNumber = List.of(1, 2, 3);
        do {
            getHint();
        } while (isGameOn);
    }

    public void notifyStart() {
        System.out.println(START_NOTICE);
    }

    public void notifyRestartOrEnd() {
        System.out.println(RESTART_OR_END_NOTICE);
    }

    public int getRestartOrEndNumber() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine());
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public void setRestarter(int restartOrEndNumber) {
        if (restartOrEndNumber == 1) {
            restarter = true;
        } else if (restartOrEndNumber == 2) {
            restarter = false;
        }
    }

}

