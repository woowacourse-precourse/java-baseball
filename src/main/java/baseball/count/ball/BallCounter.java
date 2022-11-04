package baseball.count.ball;

import java.util.List;
import java.util.stream.IntStream;

public class BallCounter {

    private int checkBall(List<Integer> answer, List<Integer> inputNumber) {
        return (int) IntStream.range(0, 3)
                .filter(i -> answer.contains(inputNumber.get(i)))
                .filter(i -> !answer.get(i).equals(inputNumber.get(i)))
                .count();
    }
}
