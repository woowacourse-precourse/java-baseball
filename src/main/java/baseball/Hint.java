package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Hint {
    private final int strike;

    public Hint(List<Integer> userNums, List<Integer> computerNums, int count) {
        strike = countStrike(userNums, computerNums, count);
    }

    public int getStrike() {
        return strike;
    }

    private int countStrike(List<Integer> userNums, List<Integer> computerNums, int count) {
        return (int) IntStream.range(0, count)
                .filter(i -> userNums.get(i) == computerNums.get(i))
                .count();
    }
}
