package baseball.count.strike;

import java.util.List;
import java.util.stream.IntStream;

public class StrikeCounter {

    public StrikeResult checkStrike(List<Integer> answer, List<Integer> inputNumber) {
        int count = (int) IntStream.range(0, 3)
                .filter(i -> answer.get(i).equals(inputNumber.get(i)))
                .count();

        return new StrikeResult(count);
    }
}
