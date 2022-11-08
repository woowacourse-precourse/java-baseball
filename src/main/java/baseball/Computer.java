package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_OR_STOP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private String[] compareResult;
    private static List<Integer> computerNumbers = new ArrayList<>();
    private int ballCount;
    private int strikeCount;
    private int nothingCount;

    public void createRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public void numberCompare() {
        createRandomNumber();
        System.out.println(computerNumbers);
        User user = new User();
        List<Integer> userNumbers = user.createUserNumber();
        compareResult = new String[3];
        for (int i = 0; i < computerNumbers.size(); i++) {
            int userNumber = userNumbers.get(i);
            if (isStrike(userNumbers, userNumber)) {
                compareResult[i] = STRIKE;
                continue;
            }
            if (isBall(userNumber)) {
                compareResult[i] = BALL;
                continue;
            }
            compareResult[i] = NOTHING;
        }
    }

    public boolean isBall(int userNumber) {
        if (computerNumbers.contains(userNumber)) {
            return true;
        }
        return false;
    }

    public boolean isStrike(List<Integer> userNumbers, int userNumber) {
        if (isBall(userNumber)) {
            int computerNumberIndex = computerNumbers.indexOf(userNumber);
            int userNumberIndex = userNumbers.indexOf(userNumber);
            if (computerNumberIndex == userNumberIndex) {
                return true;
            }
        }
        return false;
    }

    public void numberCompareResult() {
        numberCompare();
        int listSize = compareResult.length;
        for (int i = 0; i < listSize; i++) {
            String result = compareResult[i];
            if (result == STRIKE) {
                strikeCount++;
            }
            if (result == BALL) {
                ballCount++;
            }
            if (result == NOTHING) {
                nothingCount++;
            }
        }
    }

    public void gameStart() {
        while (true) {
            numberCompareResult();
            if (strikeCount == 3) {
                printStrike();
                printGameOver();
                restartGame();
                break;
            }
            printStrikeAndBall();
            printStrike();
            printBall();
            printNothing();
            countInitialization();
        }
    }

    public void printStrike() {
        if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + STRIKE);
        }
    }

    public void printGameOver() {
        System.out.println(GAME_OVER);
        System.out.println(GAME_RESTART_OR_STOP);
        computerNumbers.clear();
        countInitialization();
    }

    public void restartGame() {
        User user = new User();
        int number = user.inputRestartNumber();
        if (number == 1) {
            gameStart();
        }
    }

    public void printStrikeAndBall() {
        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        }
    }

    public void printBall() {
        if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + BALL);
        }
    }

    public void printNothing() {
        if (nothingCount == 3) {
            System.out.println(NOTHING);
        }
    }

    public void countInitialization() {
        strikeCount = 0;
        ballCount = 0;
        nothingCount = 0;
    }
}