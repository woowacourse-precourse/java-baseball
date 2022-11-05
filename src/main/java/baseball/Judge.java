package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Judge {
    private final List<Integer> ANSWER;

    public Judge(List<Integer> ANSWER) {
        this.ANSWER = ANSWER;
    }

    private int countBall(List<Integer> guess) {
        return (int) guess.stream()
                .filter(number -> ANSWER.contains(number))
                .count();
    }

    private int countStrike(List<Integer> guess) {
        return (int) IntStream.range(0, 3)
                .filter(index -> ANSWER.get(index) == guess.get(index))
                .count();
    }

    public List<Integer> judgeUserGuess(List<Integer> guess) {
        int strikeCount = countStrike(guess);
        int ballCount = countBall(guess) - strikeCount;

        return List.of(ballCount, strikeCount);
    }
}
