package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.stream.IntStream;

public class Computer {
    private String answer;

    public void setAnswer() {
        StringBuilder answerBuilder = new StringBuilder();
        HashSet<Integer> numSet = new HashSet<>();

        while (numSet.size() < Constants.NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END);
            if (numSet.add(randomNumber)) {
                answerBuilder.append(randomNumber);
            }
        }

        this.answer = answerBuilder.toString();
    }

    private int countBall(String Input) {
        int ball;

        ball = (int) IntStream.range(0, Input.length()).
                filter(guessIdx -> IntStream.range(0, answer.length()).
                        filter(answerIdx -> guessIdx != answerIdx).
                        anyMatch(answerIdx -> Input.charAt(guessIdx) == answer.charAt(answerIdx))).
                count();

        return ball;
    }

    private int countStrike(String input) {
        int strike;

        strike = (int) IntStream.range(0, input.length()).
                filter(idx -> input.charAt(idx) == answer.charAt(idx)).
                count();

        return strike;
    }
}
