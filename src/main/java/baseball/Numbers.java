package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {
    public static final int LENGTH = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;

    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(List<Integer> numbers) {
        if (validation(numbers)) {
            return new Numbers(numbers);
        }
        throw new IllegalArgumentException("잘못된 입력입니다");
    }

    public static Numbers of(int... numbers) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        return Numbers.of(list);
    }

    private static boolean validation(List<Integer> numbers) {
        if (numbers.size() != LENGTH) {
            return false;
        }
        for (int i = 0; i < LENGTH; i++) {
            if (numbers.get(i) < MIN || numbers.get(i) > MAX) {
                return false;
            }
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == LENGTH;
    }

    public int get(int i) {
        return numbers.get(i);
    }

    public int indexOf(int i) {
        return numbers.indexOf(i);
    }
}
