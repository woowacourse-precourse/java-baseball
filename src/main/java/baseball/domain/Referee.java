package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private static final int COUNT_VALUE = 3;
    private static final int START_VALUE = 0;
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
    public Referee() {
        this.strike = START_VALUE;
        this.ball = START_VALUE;
    }

    public void scoreStrikeAndBallCount(int[] predictedValue,int[] answer){
        this.strike = START_VALUE;
        this.ball = START_VALUE;

        List<Integer> answerList = convertArrayToList(answer);
        printPredictedValue(predictedValue);
        countStrike(predictedValue, answerList);
        countBall(predictedValue, answerList);

    }

    private static List<Integer> convertArrayToList(int[] answer) {
        List<Integer> answerList = new ArrayList<>();
        for (int element : answer) {
            answerList.add(element);
        }
        return answerList;
    }

    private static void printPredictedValue(int[] predictedValue) {
        for (int i = 0; i < predictedValue.length; i++) {
            System.out.print(predictedValue[i]);
        }
        System.out.println();
    }

    private void countBall(int[] predictedValue, List<Integer> answerList) {
        for (int i = 0; i < COUNT_VALUE; i++) {
            int index = answerList.indexOf(predictedValue[i]);
            if (answerList.get(i) != predictedValue[i] && index >= 0) {
                ball++;
            }
        }
    }

    private void countStrike(int[] predictedValue, List<Integer> answerList) {
        for (int i = 0; i < COUNT_VALUE; i++) {
            if (answerList.get(i) == predictedValue[i]) {
                strike++;
            }
        }
    }

    public boolean countOut() {
        if (strike == COUNT_VALUE) {
            return true;
        }
        return false;
    }
}
