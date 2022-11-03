package baseball.game;

import baseball.constant.GameConstant;

import java.util.List;

public class Comparator {

    private static Comparator comparator;
    private int strike;
    private int ball;

    private Comparator() {
        this.strike = 0;
        this.ball = 0;
    }

    public static Comparator getInstance() {
        if(comparator == null) {
            comparator = new Comparator();
        }

        return comparator;
    }

    public Comparator compare(List<Integer> answer, List<Integer> userInput) {
        strike = getEqualDigitCount(answer, userInput);
        ball = getContainNumberCount(answer, userInput) - strike;

        return comparator;
    }

    private int getEqualDigitCount(List<Integer> answer, List<Integer> userInput) {
        int equalDigitCount = 0;
        for(int digit = 0; digit < GameConstant.DIGIT.getValue(); digit++) {
            if(answer.get(digit).equals(userInput.get(digit))) {
                equalDigitCount++;
            }
        }

        return equalDigitCount;
    }

    private int getContainNumberCount(List<Integer> answer, List<Integer> userInput) {
        int containCount = 0;

        for(Integer digit : userInput) {
            if(answer.contains(digit)) {
                containCount++;
            }
        }

        return containCount;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
