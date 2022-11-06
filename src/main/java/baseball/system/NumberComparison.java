package baseball.system;

import baseball.utils.*;

import java.util.*;

public class NumberComparison {
    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;
    private int strikeCount;
    private int ballCount;

    public NumberComparison(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public boolean startComparison(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;

        strikeCount = countStrike();
        ballCount = countBall();

        printStrikeBallCount(strikeCount, ballCount);

        if (isAnswer(strikeCount)) {
            return true;
        }

        return false;
    }

    private int countBall() {
        int ballCount = 0;

        int userNumber;
        int computerNumber;

        for (int index = 0; index < BaseballConstant.NUMBERS_COUNT; index++) {

            userNumber = userNumbers.get(index);
            computerNumber = computerNumbers.get(index);

            if (!IsCollection.isSameValue(computerNumber, userNumber)
                    && IsCollection.hasNumber(computerNumbers, userNumber)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private int countStrike() {

        int strikeCount = 0;

        int userNumber;
        int computerNumber;

        for (int index = 0; index < BaseballConstant.NUMBERS_COUNT; index++) {

            userNumber = userNumbers.get(index);
            computerNumber = computerNumbers.get(index);

            if (IsCollection.isSameValue(userNumber, computerNumber)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private boolean isAnswer(int strikeCount) {
        return IsCollection.isSameValue(strikeCount, BaseballConstant.MAX_COUNT);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    private void printStrikeBallCount(int strikeCount, int ballCount) {
        final int ZERO_COUNT = BaseballConstant.ZERO_COUNT;

        if (strikeCount == ZERO_COUNT && ballCount == ZERO_COUNT) {
            System.out.println("낫싱");
            return;
        }

        if (ballCount != ZERO_COUNT) {
            System.out.print(ballCount + "볼");
        }

        if (ballCount != ZERO_COUNT && strikeCount != ZERO_COUNT) {
            System.out.print(" ");
        }

        if (strikeCount != ZERO_COUNT) {
            System.out.print(strikeCount + "스트라이크");
        }

        System.out.println();
    }
}
