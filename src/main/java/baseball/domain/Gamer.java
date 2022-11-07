package baseball.domain;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gamer {
    public List<Integer> inputNumbers() {
        String inputNumbers = Console.readLine();

        InputException.isNumber(inputNumbers);
        InputException.isLength(inputNumbers);
        InputException.isDuplicate(inputNumbers);

        int[] numbers = toIntArray(inputNumbers);
        return toList(numbers);
    }

    private int[] toIntArray(String inputNumbers) {
        return Stream.of(inputNumbers.split("")).mapToInt(Integer::parseInt).toArray();
    }

    private List<Integer> toList(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }
}
