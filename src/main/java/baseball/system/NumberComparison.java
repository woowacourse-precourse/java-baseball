package baseball.system;

import java.util.*;

public class NumberComparison {

    private final int NUMBERS_SIZE = 3;
    private final int ANSWER_COUNT = 3;

    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    public NumberComparison(List<Integer> computerNumbers){
        this.computerNumbers = computerNumbers;
    }

    public boolean startComparison(List<Integer> userNumbers) {

        this.userNumbers = userNumbers;

        int strikeCount = getStrikeCount();
        int ballCount = getBallCount(); //TODO : if문 다음으로 이동 시킬 것

        if (isNothing(strikeCount, ballCount)) {
            printNothingText();
            return false;
        }

        printStrikeBallCount(strikeCount, ballCount);

        if (isAnswer(strikeCount)) {
            return true;
        }

        return false;

    }

    private void printStrikeBallCount(int strikeCount, int ballCount) {

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

    private void printNothingText() {
        System.out.println("낫싱");
    }

    private boolean isNothing(int strikeCount, int ballCount) {
        return strikeCount == 0 && ballCount == 0;
    }

    private boolean isAnswer(int strikeCount) {
        return strikeCount == ANSWER_COUNT;
    }

    private int getBallCount() {

        int ballCount = 0;

        for (int index = 0; index < NUMBERS_SIZE; index++) {

            List<Integer> IndexNumbers = new ArrayList<>(Arrays.asList(0, 1, 2));
            IndexNumbers.remove(index);

            int userNumber = userNumbers.get(index);

            if (searchNumber(IndexNumbers, userNumber)) {
                ballCount++;
            }

        }

        return ballCount;

    }

    private boolean searchNumber(List<Integer> indexNumbers, int userNumber) {

        for (int index = 0; index < NUMBERS_SIZE - 1; index++) {
            int remainedIndex = indexNumbers.get(index);
            if (userNumber == computerNumbers.get(remainedIndex)) {
                return true;
            }
        }

        return false;

    }

    private int getStrikeCount() {

        int strikeCount = 0;

        for (int index = 0; index < NUMBERS_SIZE; index++) {
            if (userNumbers.get(index) == computerNumbers.get(index)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

}
