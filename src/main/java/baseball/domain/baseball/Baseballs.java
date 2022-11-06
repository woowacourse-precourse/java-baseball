package baseball.domain.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {
    private static final int BASEBALL_NUMBER = 3;
    static final String NOT_THREE_LETTERS_MESSAGE = "입력한 숫자가 3글자가 아닙니다.";
    static final String DUPLICATE_MESSAGE = "중복된 숫자를 입력했습니다.";

    private List<Baseball> baseballs;

    public Baseballs(List<Baseball> baseballs) {
        this.baseballs = baseballs;
    }

    public List<Baseball> getBaseballs() {
        return baseballs;
    }

    public static Baseballs random() {
        Set<Baseball> randomBaseBalls = new HashSet<>();

        while (randomBaseBalls.size() < BASEBALL_NUMBER) {
            randomBaseBalls.add(Baseball.random());
        }

        return new Baseballs(new ArrayList<>(randomBaseBalls));
    }

    public static Baseballs valueOf(String numbers) {
        List<Baseball> baseballs = toBaseballs(numbers);
        validateNumber(baseballs);

        return new Baseballs(baseballs);
    }

    private static List<Baseball> toBaseballs(String numbers) {
        return numbers.chars().boxed().map(Baseball::of).collect(Collectors.toList());
    }

    private static void validateNumber(List<Baseball> baseballs) {
        validateCharacterCount(baseballs.size());
        validateDuplicate(baseballs);
    }

    private static void validateCharacterCount(int size) {
        if (size != BASEBALL_NUMBER) {
            throw new IllegalArgumentException(NOT_THREE_LETTERS_MESSAGE);
        }
    }

    private static void validateDuplicate(List<Baseball> baseballs) {
        if (baseballs.stream().distinct().count() != BASEBALL_NUMBER) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public int getStrike(Baseballs baseballs) {
        return (int) this.baseballs.stream()
                .filter(baseball -> this.baseballs.indexOf(baseball) ==
                        baseballs.baseballs.indexOf(baseball))
                .count();
    }

    public int getBall(Baseballs baseballs) {
        return (int) this.baseballs.stream()
                .filter(baseball -> baseballs.baseballs.contains(baseball) &&
                        this.baseballs.indexOf(baseball) !=
                                baseballs.baseballs.indexOf(baseball))
                .count();
    }
}
