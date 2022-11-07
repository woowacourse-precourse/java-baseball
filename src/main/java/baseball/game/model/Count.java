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

    public boolean isNothing() {
        return BALL == 0 && STRIKE == 0;
    }


    public boolean isCorrect() {
        return STRIKE == Constants.FULL_STRIKE;
    }

    @Override
    public String toString() {
        String hint = "";

        if (isNothing()) {
            hint += "낫싱";
            return hint;
        }

        if (BALL != Constants.NOTHING) {
            hint += BALL + "볼 ";
        }

        if (STRIKE != Constants.NOTHING) {
            hint += STRIKE + "스트라이크";
        }

        return hint;
    }
}
