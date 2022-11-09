package baseball.game;

import java.util.List;

import static baseball.game.BaseballGame.BASEBALL_LENGTH_LIMIT;
import static baseball.util.RandomGenerator.createRandomIntList;

public class Baseball {

    private final List<Integer> numbers;

    public Baseball(int start, int end, int limit) {
        this.numbers = createRandomIntList(start, end, limit);
    }

    public int getStrikeCount(List<Integer> input) {
        return (int) input.stream()
                .filter(n -> input.indexOf(n) == numbers.indexOf(n))
                .count();
    }

    public int getBallCount(List<Integer> input) {
        return (int) input.stream()
                .filter(numbers::contains)
                .filter(n -> input.indexOf(n) != numbers.indexOf(n))
                .count();
    }

    public boolean isGuessFailed(List<Integer> input) {
        return input.stream()
                .filter(n -> input.indexOf(n) == numbers.indexOf(n))
                .count() != BASEBALL_LENGTH_LIMIT;
    }
}
