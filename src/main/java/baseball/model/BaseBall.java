package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBall extends RandomMaker {
    public static final int MAX_BASEBALL_SIZE = 3;

    private static final int INITIAL_STRIKE = 0;
    private static final int INITIAL_BALL = 0;
    private static final int MIN_RANDOM_PICK = 1;
    private static final int MAX_RANDOM_PICK = 9;

    private static List<Integer> answer = new ArrayList<>();

    public BaseBall() {
        answer = makeThreeRandomNumbers();
    }

    @Override
    protected List<Integer> makeThreeRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != MAX_BASEBALL_SIZE) {
            numbers.add(Randoms.pickNumberInRange(MIN_RANDOM_PICK, MAX_RANDOM_PICK));
        }
        return new ArrayList<>(numbers);
    }

    public Score compareAnswer(List<Integer> input) {
        int strike = findStrike(input);
        int ball = findBall(input);

        return new Score(strike, ball);
    }

    private int findStrike(List<Integer> input) {
        int strike = INITIAL_STRIKE;
        for (int inputIndex = 0; inputIndex < MAX_BASEBALL_SIZE; inputIndex++) {
            Integer currentNumber = input.get(inputIndex);
            strike = compareAnswerWhetherStrike(strike, inputIndex, currentNumber);
        }
        return strike;
    }

    private static int compareAnswerWhetherStrike(int strike, int inputIndex, Integer currentNumber) {
        for (int answerIndex = 0; answerIndex < MAX_BASEBALL_SIZE; answerIndex++) {
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
        int ball = INITIAL_BALL;
        for (int inputIndex = 0; inputIndex < MAX_BASEBALL_SIZE; inputIndex++) {
            Integer currentNumber = input.get(inputIndex);
            ball = compareAnswerWhetherBall(ball, inputIndex, currentNumber);
        }
        return ball;
    }

    private static int compareAnswerWhetherBall(int ball, int inputIndex, Integer currentNumber) {
        for (int answerIndex = 0; answerIndex < MAX_BASEBALL_SIZE; answerIndex++) {
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
