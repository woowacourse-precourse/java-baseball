package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private static final int LENGTH = 3;
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean validation() {
        if (numbers.size() != LENGTH) {
            return false;
        }
        for (int i = 0; i < LENGTH; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 9) {
                return false;
            }
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == LENGTH;
    }
}
