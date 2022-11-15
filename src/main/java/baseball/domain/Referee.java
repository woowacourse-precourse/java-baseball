package baseball.domain;

import baseball.common.Constant;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;


public final class Referee {

    private Referee() {}

    public static int findStrikeCount(List<Integer> computer, List<Integer> player) {
        return (int) IntStream.range(0, Constant.MAX_STRIKE_SIZE)
                .filter(i -> Objects.equals(computer.get(i), player.get(i)))
                .count();
    }

    public static int findBallCount(List<Integer> computer, List<Integer> player) {
        return (int) IntStream.range(0, Constant.MAX_STRIKE_SIZE)
                .filter(i -> player.contains(computer.get(i)))
                .filter(i -> !Objects.equals(computer.get(i), player.get(i)))
                .count();
    }
}
