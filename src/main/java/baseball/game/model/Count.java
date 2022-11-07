package baseball.game.model;

import baseball.game.common.Constants;

import java.util.List;
import java.util.stream.IntStream;

public class Count {
    private final int BALL;
    private final int STRIKE;

    public Count(List<Integer> computerNumber, List<Integer> userNumber) {
        BALL = setBall(computerNumber, userNumber);
        STRIKE = setStrike(computerNumber, userNumber);
    }

    public int setBall(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, Constants.ESSENTIAL_LENGTH)
                .filter(i -> computerNumber.get(i) != userNumber.get(i) && computerNumber.contains(userNumber.get(i)))
                .count();
    }

    public int setStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0,Constants.ESSENTIAL_LENGTH)
                .filter(i -> computerNumber.get(i) == userNumber.get(i))
                .count();
    }
}
