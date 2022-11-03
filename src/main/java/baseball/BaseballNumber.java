package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    private final List<Integer> numbers;
    private final Set<Integer> numbersSet;

    public static final int NUMBER_COUNT = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "중복된 숫자가 있습니다";
    public static final String NOT_PROPER_SIZE_EXCEPTION_MESSAGE = "올바른 숫자 개수가 아닙니다";
    public static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "범위를 벗어난 숫자입니다";

    public BaseballNumber(List<Integer> numbers) throws IllegalArgumentException {
        this.numbers = numbers;
        this.numbersSet = new HashSet<>(numbers);

        if (is_not_proper_size(numbers)) {
            throw new IllegalArgumentException(NOT_PROPER_SIZE_EXCEPTION_MESSAGE);
        }

        for (Integer number : numbers) {
            if (is_out_of_range(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }

        if (has_duplicate_numbers(numbers, numbersSet)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }

    }

    private boolean is_not_proper_size(List<Integer> numbers) {
        return numbers.size() != NUMBER_COUNT;
    }

    private boolean has_duplicate_numbers(List<Integer> numbers, Set<Integer> numbersSet) {
        return numbers.size() != numbersSet.size();

    }

    private boolean is_out_of_range(int number) {
        return (number < MIN_NUMBER || number > MAX_NUMBER);
    }
}
