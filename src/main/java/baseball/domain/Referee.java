package baseball.domain;

import baseball.util.CompareResult;
import java.util.LinkedList;
import java.util.Queue;

public class Referee {

    private final int MAX_NUMBER_SIZE = 3;

    private static Referee instance;

    public static Referee getInstance() {
        if (instance == null) {
            instance = new Referee();
        }
        return instance;
    }

    public String judge(String input, String answer) {
        int strike = countStrike(input, answer);
        int ball = countBall(input, answer);
        return createJudgement(strike, ball);
    }

    public int countStrike(String input, String answer) {
        int count = 0;
        for (int index = 0; index < MAX_NUMBER_SIZE; index++) {
            if (isSame(input.charAt(index), answer.charAt(index))) {
                count++;
            }
        }
        return count;
    }

    public boolean isSame(char inputNumber, char answerNumber) {
        return inputNumber == answerNumber;
    }

    public int countBall(String input, String answer) {
        Queue<Character> compareTarget = makeCompareTarget(answer);

        int count = 0;
        for (int inputIdx = 0; inputIdx < input.length(); inputIdx++) {
            char firstNumber = compareTarget.poll();

            char target = input.charAt(inputIdx);
            if (isCompareTargetContainsTarget(compareTarget, target)) {
                count++;
            }
            compareTarget.add(firstNumber);
        }

        return count;
    }

    private Queue<Character> makeCompareTarget(String answer) {
        Queue<Character> compareTarget = new LinkedList<>();
        for (int answerIndex = 0; answerIndex < answer.length(); answerIndex++) {
            char digitOfAnswer = answer.charAt(answerIndex);
            compareTarget.add(digitOfAnswer);
        }

        return compareTarget;
    }

    private boolean isCompareTargetContainsTarget(Queue<Character> compareTarget, char target) {
        return compareTarget.contains(target);
    }

    public String createJudgement(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return CompareResult.NOTHING.getValue();
        } else if (strike == MAX_NUMBER_SIZE) {
            return CompareResult.THREE_STRIKE.getValue();
        } else if (strike == 0 && ball != 0) {
            return ball + CompareResult.BALL.getValue();
        } else if (strike != 0 && ball == 0) {
            return strike + CompareResult.STRIKE.getValue();
        }
        return ball + CompareResult.BALL.getValue() + " " + strike + CompareResult.STRIKE.getValue();
    }

    public boolean isThreeStrike(String judgement) {
        return (judgement == CompareResult.THREE_STRIKE.getValue());
    }
}
