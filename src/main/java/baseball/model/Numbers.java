package baseball.model;

import java.util.List;
import java.util.function.BiConsumer;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void iterateForEach(BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < numbers.size(); i++) {
            consumer.accept(i, numbers.get(i));
        }
    }

    public boolean containAnswer(int number) {
        return numbers.contains(number);
    }

    public boolean matchStrike(int index, int number) {
        if (index >= numbers.size()) {
            return false;
        }

        return numbers.get(index).equals(number);
    }
}
