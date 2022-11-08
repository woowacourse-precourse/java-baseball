package baseball.game.model;

import baseball.game.constants.Common;

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
        return (int) IntStream.range(0, Common.ESSENTIAL_LENGTH)
                .filter(i -> computerNumber.get(i) != userNumber.get(i) && computerNumber.contains(userNumber.get(i)))
                .count();
    }

    public int setStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, Common.ESSENTIAL_LENGTH)
                .filter(i -> computerNumber.get(i) == userNumber.get(i))
                .count();
    }

    public boolean isNothing() {
        return BALL == 0 && STRIKE == 0;
    }

    public boolean isCorrect() {
        return STRIKE == Common.FULL_STRIKE;
    }

    public String getBallCount() {
        if (BALL != Common.NOTHING) {
            return BALL + "볼 ";
        }
        return "";
    }

    public String getStrikeCount() {
        if (STRIKE != Common.NOTHING) {
            return STRIKE + "스트라이크";
        }
        return "";
    }

    @Override
    public String toString() {
        if (isNothing()) { return "낫싱"; }

        String hint = "";

        hint += getBallCount();
        hint += getStrikeCount();

        return hint;
    }
}
