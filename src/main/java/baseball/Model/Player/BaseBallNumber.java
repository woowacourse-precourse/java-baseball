package baseball.Model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class BaseBallNumber {

    private static final int GAME_NUMBER_SIZE = 3;

    private final List<Character> numbers;

    public BaseBallNumber(List<Character> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static void validateSize(List<Character> numbers) {
        if (numbers.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    "Baseball number length should be " + GAME_NUMBER_SIZE);
        }
    }

    public static void validateDuplicate(List<Character> numbers) {
        Set<Character> number = new HashSet<>(numbers);
        if (number.size() != numbers.size()) {
                throw new IllegalArgumentException("Baseball number has duplicate number.");
        }
    }

    @Override
    public String toString() {
        return (numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }
}
