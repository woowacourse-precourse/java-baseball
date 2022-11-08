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

    public List<Integer> createRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public void createCompareResult() {
        User user = new User();
        compareResult = new String[3];
        List<Integer> computerNumbers = createRandomNumber();
        List<Integer> userNumbers = user.createUserNumber();
        inputCompareResult(computerNumbers, userNumbers);
    }

    public void inputCompareResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int userNumber = userNumbers.get(i);
            if (isSameIndexOfSameNumber(computerNumbers, userNumbers, userNumber)) {
                compareResult[i] = STRIKE;
                continue;
            }
            if (isContainsNumber(computerNumbers, userNumber)) {
                compareResult[i] = BALL;
                continue;
            }
            compareResult[i] = NOTHING;
        }
    }

    public boolean isContainsNumber(List<Integer> computerNumbers, int number) {
        if (computerNumbers.contains(number)) {
            return true;
        }
        return false;
    }

    public boolean isSameIndexOfSameNumber(List<Integer> computerNumbers, List<Integer> userNumbers, int number) {
        if (isContainsNumber(computerNumbers, number)) {
            int computerNumberIndex = computerNumbers.indexOf(number);
            int userNumberIndex = userNumbers.indexOf(number);
            if (computerNumberIndex == userNumberIndex) {
                return true;
            }
        }
        return false;
    }

    public void compareGameScore() {
        createCompareResult();
        for (int i = 0; i < compareResult.length; i++) {
            if (compareResult[i] == STRIKE) {
                strikeCount++;
            }
            if (compareResult[i] == BALL) {
                ballCount++;
            }
            if (compareResult[i] == NOTHING) {
                nothingCount++;
            }
        }
    }

    public void countInitialization() {
        strikeCount = 0;
        ballCount = 0;
        nothingCount = 0;
    }

    public void printGameResult() {
        User user = new User();
        while (true) {
            compareGameScore();
            if (strikeCount == 3) {
                printStrike();
                printGameOver();
                computerNumbers.clear();
                restartGame();
                break;
            }
            if (ballCount > 0 && strikeCount > 0) {
                System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
            }
            printStrike();
            printBall();
            printNothing();
            countInitialization();
        }
    }

    public void printGameOver() {
        System.out.println(GAME_OVER);
        System.out.println(GAME_RESTART_OR_STOP);
    }

    public void printStrike() {
        if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + STRIKE);
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

    public void restartGame() {
        User user = new User();
        int number = user.inputRestartNumber();
        if (number == 1) {
            printGameResult();
        }
    }
}