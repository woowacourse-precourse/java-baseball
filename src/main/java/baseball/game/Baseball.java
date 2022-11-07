package baseball.game;

import java.util.List;

import static baseball.util.RandomGenerator.createRandomIntList;

public class Baseball {

    private final List<Integer> numbers;

    public Baseball(int start, int end, int limit) {
        this.numbers = createRandomIntList(start, end, limit);
    }
}
