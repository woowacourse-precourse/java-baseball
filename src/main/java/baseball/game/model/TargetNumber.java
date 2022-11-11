package baseball.game.model;

import java.util.List;
import java.util.function.BiConsumer;

public class TargetNumber {

    private final List<Integer> numbers;

    public TargetNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void indexedForEach(BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < numbers.size(); i++) {
            consumer.accept(numbers.get(i), i);
        }
    }
}
