package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Computer.*;
import static baseball.User.*;

public class Referee {
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    static final String OUT = "낫싱";
    static final String CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final int MAX_SIZE = 3;

    private int ballCount;
    private int strikeCount;

    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    public void resetReferee(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
    }

    public boolean judgeReferee(List<Integer> computerNumbers, List<Integer> userNumbers) {
        resetReferee(computerNumbers, userNumbers);
        ballCount = countBall();
        strikeCount = countStrike();
        printMessage();
        return isCorrect();
    }

    public boolean isBall(int index) {
        if (computerNumbers.contains(userNumbers.get(index))) {
            return true;
        }
        return false;
    }

    public int countBall() {
        int count = 0;
        for (int index = 0; index < MAX_SIZE; index++) {
            if (isBall(index) && !isStrike(index)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isStrike(int index) {
        if (computerNumbers.get(index).equals((userNumbers).get(index))) {
            return true;
        }
        return false;
    }

    public int countStrike() {
        int count = 0;
        for (int index = 0; index < MAX_SIZE; index++) {
            if (isStrike(index)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isCorrect() {
        if (strikeCount == MAX_SIZE) {
            return true;
        }
        return false;
    }

    public void printMessage() {
        if (isCorrect()) {
            System.out.println(strikeCount + STRIKE);
            System.out.println(CORRECT);
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        } else if (ballCount != 0) {
            System.out.println(ballCount + BALL);
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + STRIKE);
        } else {
            System.out.println(OUT);
        }
    }

}
