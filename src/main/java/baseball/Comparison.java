package baseball;

import java.util.List;
import java.util.Objects;

public class Comparison {
    public static boolean isAnswered(List<Integer> userNumber, List<Integer> answerNumber) {
        int ballCount = countBallNumbers(userNumber, answerNumber);
        int strikeCount = countStrikeNumbers(userNumber, answerNumber);
        String message = Information.createComparisonMessage(ballCount, strikeCount);
        System.out.println(message);

        return strikeCount == Number.MAX_SIZE;
    }

    public static int countBallNumbers(List<Integer> userNumber, List<Integer> answerNumber) {
        int ballTotalCount = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isBall(answerNumber, userNumber.get(index), index)) {
                ballTotalCount++;
            }
        }
        return ballTotalCount;
    }

    public static int countStrikeNumbers(List<Integer> userNumber, List<Integer> answerNumber) {
        int strikeTotalCount = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isStrike(userNumber, answerNumber, index)) {
                strikeTotalCount++;
            }
        }
        return strikeTotalCount;
    }

    public static boolean isNothing(int ballCount, int strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }

    public static boolean isBall(List<Integer> answerNumber, int number, int index) {
        return answerNumber.get(index) != number && answerNumber.contains(number);
    }

    public static boolean isStrike(List<Integer> userNumber, List<Integer> answerNumber, int index) {
        return Objects.equals(userNumber.get(index), answerNumber.get(index));
    }
}
