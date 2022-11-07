package baseball.domain;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gamer {
    public Set<Integer> inputNumbers() {
        String inputNumbers = Console.readLine();
        InputException.isNumber(inputNumbers);
        InputException.isLength(inputNumbers);
        int[] numbers = toIntArray(inputNumbers);
        return toSet(numbers);
    }

    private int[] toIntArray(String inputNumbers) {
        return Stream.of(inputNumbers.split("")).mapToInt(Integer::parseInt).toArray();
    }

    private Set<Integer> toSet(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toSet());
    }
}
