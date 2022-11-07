package baseball.domain;

import baseball.util.GameRule;

import java.util.List;

public class PitchResult {

    private int strikeCount;
    private int ballCount;

    public void setResult(String userInput, List<Integer> numbers) {
        strikeCount = setStrikeCount(userInput.toCharArray(), numbers);
        ballCount = setBallCount(userInput.toCharArray(), numbers);
    }

    private int setStrikeCount(char[] userInput, List<Integer> numbers) {
        int strikeCount = 0;
        for (int index = 0; index < GameRule.NUMBER_OF_NUMBERS; index++) {
            if (Character.getNumericValue(userInput[index]) == numbers.get(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int setBallCount(char[] userInput, List<Integer> numbers) {
        int sumOfStrikeAndBall = 0;
        for (int index = 0; index < GameRule.NUMBER_OF_NUMBERS; index++) {
            sumOfStrikeAndBall += numberOfAnyDigitsSameNumber(userInput[index], numbers);
        }
        return sumOfStrikeAndBall - strikeCount;
    }

    private int numberOfAnyDigitsSameNumber(char digit, List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (Character.getNumericValue(digit) == number) {
                count++;
            }
        }
        return count;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
