package baseball.count.ball;

import java.util.List;
import java.util.stream.IntStream;

public class BallCounter {

    public BallResult checkBall(List<Integer> answer, List<Integer> inputNumber) {
        int count = (int) IntStream.range(0, 3)
                .filter(i -> answer.contains(inputNumber.get(i)))
                .filter(i -> !answer.get(i).equals(inputNumber.get(i)))
                .count();

        return new BallResult(count);
    }
}
