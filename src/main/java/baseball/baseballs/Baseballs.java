package baseball.baseballs;

import baseball.game.Result;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {
    private static final int BASEBALL_COUNT = 3;
    private static char MIN_VALID_RANGE = '1';
    private static char MAX_VALID_RANGE = '9';

    private List<Baseball> baseballs;

    public static Baseballs of(String userInput) {
        return new Baseballs(userInput);
    }

    private Baseballs(String userInput) {
        validate(userInput);
        this.baseballs = userInput.chars()
                .mapToObj(value -> (char) value)
                .map(Baseball::new)
                .collect(Collectors.toList());
    }

    public Result calculateResult(Baseballs another) {
        return Result.scoreOf(countStrike(another), countBall(another));
    }

    public int countStrike(Baseballs another) {
        return (int) IntStream.range(0, BASEBALL_COUNT)
                .filter(order -> this.baseballs.get(order).equals(another.baseballs.get(order)))
                .count();
    }

    public int countBall(Baseballs another) {
        return (int) this.baseballs.stream()
                .filter(baseball ->
                        another.baseballs.contains(baseball)
                                && this.baseballs.indexOf(baseball) != another.baseballs.indexOf(baseball)
                )
                .count();
    }

    private void validate(String userInput) {
        isEmpty(userInput);
        isLengthEqualsBaseballCount(userInput);
        isConsistOfOnlyProperRangedInputs(userInput);
        hasDuplicatedValueIn(userInput);
    }

    private void hasDuplicatedValueIn(String userInput) {
        if (userInput.chars()
                .distinct()
                .count() != BASEBALL_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void isConsistOfOnlyProperRangedInputs(String userInput) {
        for (Character characterInUserInput : userInput.toCharArray()) {
            isProperRangedInput(characterInUserInput);
        }
    }

    private void isProperRangedInput(Character characterInUserInput) {
        if (characterInUserInput < MIN_VALID_RANGE || characterInUserInput > MAX_VALID_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private void isLengthEqualsBaseballCount(String userInput) {
        if (userInput.length() != BASEBALL_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void isEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
