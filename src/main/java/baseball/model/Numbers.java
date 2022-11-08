package baseball.model;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class Numbers {
    private Integer[] numbers;

    public Numbers(Integer[] numbers) {
        this.numbers = numbers;
    }

    public void indexedForEach(BiConsumer<Integer, Integer> biConsumer) {
        for (int i = 0; i < numbers.length; i++) {
            biConsumer.accept(numbers[i], i);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
}
