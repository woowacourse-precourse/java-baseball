package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    public static final int MAX_BASEBALL_LENGTH = 3;

    private static List<Integer> answer = new ArrayList<>();

    public BaseBall() {
        this.answer = Randoms.pickUniqueNumbersInRange(0, 9, 3);
    }

    public Answer compareAnswer(List<Integer> input) {
        int strike = findStrike(input);
        int ball = findBall(input);

        return new Answer(strike, ball);
    }

    private int findStrike(List<Integer> input) {
        int strike = 0;
        for (int inputIndex = 0; inputIndex < MAX_BASEBALL_LENGTH; inputIndex++) {
            Integer currentNumber = input.get(inputIndex);
            strike = compareAnswerWhetherStrike(strike, inputIndex, currentNumber);
        }
        return strike;
    }

    private static int compareAnswerWhetherStrike(int strike, int inputIndex, Integer currentNumber) {
        for (int answerIndex = 0; answerIndex < MAX_BASEBALL_LENGTH; answerIndex++) {
            strike = increaseIfStrike(strike, inputIndex, currentNumber, answerIndex);
        }
        return strike;
    }

    private static int increaseIfStrike(int strike, int inputIndex, Integer currentNumber, int answerIndex) {
        if (isDifferentIndex(inputIndex, answerIndex)) {
            return strike;
        }

        Integer currentAnswer = answer.get(answerIndex);
        if (isStrike(currentNumber, currentAnswer)) {
            strike++;
        }

        return strike;
    }

    private static boolean isDifferentIndex(int inputIndex, int answerIndex) {
        return inputIndex != answerIndex;
    }

    private static boolean isStrike(Integer currentNumber, Integer currentAnswer) {
        return currentNumber.equals(currentAnswer);
    }

    private int findBall(List<Integer> input) {
        int ball = 0;
        for (int inputIndex = 0; inputIndex < MAX_BASEBALL_LENGTH; inputIndex++) {
            Integer currentNumber = input.get(inputIndex);
            ball = compareAnswerWhetherBall(ball, inputIndex, currentNumber);
        }
        return ball;
    }

    private static int compareAnswerWhetherBall(int ball, int inputIndex, Integer currentNumber) {
        for (int answerIndex = 0; answerIndex < MAX_BASEBALL_LENGTH; answerIndex++) {
            ball = increaseIfBall(ball, inputIndex, currentNumber, answerIndex);
        }
        return ball;
    }

    private static int increaseIfBall(int ball, int inputIndex, Integer currentNumber, int answerIndex) {
        if (inputIndex == answerIndex) {
            return ball;
        }

        Integer currentAnswer = answer.get(answerIndex);
        if (currentNumber.equals(currentAnswer)) {
            ball++;
        }
        return ball;
    }
}
