package baseball.system;

import baseball.utils.NumberParsing;

import java.util.*;

public class NumberComparison {

    private final int NUMBERS_SIZE = 3;
    private final int ANSWER_COUNT = 3;

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

        for (int index = 0; index < NUMBERS_SIZE; index++) {

            userNumber = userNumbers.get(index);
            computerNumber = computerNumbers.get(index);

            if (!NumberParsing.isSameNumber(computerNumber, userNumber)
                    && NumberParsing.hasNumber(computerNumbers, userNumber)) {
                ballCount++;
            }

        }

        return ballCount;

    }


    private int countStrike() {

        int strikeCount = 0;

        int userNumber;
        int computerNumber;

        for (int index = 0; index < NUMBERS_SIZE; index++) {

            userNumber = userNumbers.get(index);
            computerNumber = computerNumbers.get(index);

            if (NumberParsing.isSameNumber(userNumber, computerNumber)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private boolean isAnswer(int strikeCount) {
        return strikeCount == ANSWER_COUNT;
    }
    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    private void printStrikeBallCount(int strikeCount, int ballCount) {

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ballCount != 0) {
            System.out.print(ballCount + "볼");
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(" ");
        }

        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }

        System.out.println();

    }

}
