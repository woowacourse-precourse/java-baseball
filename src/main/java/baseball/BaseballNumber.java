package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumber {

    private final List<Integer> numbers;
    private final Set<Integer> numbersSet;

    public static final int NUMBER_COUNT = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "중복된 숫자가 있습니다";
    public static final String NOT_PROPER_SIZE_EXCEPTION_MESSAGE = "올바른 숫자 개수가 아닙니다";
    public static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "범위를 벗어난 숫자입니다";
    public static final String NOT_A_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다";

    public BaseballNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> numbersSet = new HashSet<>(numbers);

        are_all_constrains_met(numbers, numbersSet);

        this.numbers = numbers;
        this.numbersSet = numbersSet;
    }

    public BaseballNumber(String numbersString) throws IllegalArgumentException {
        try {
            List<Integer> numbers = Arrays.stream(numbersString.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Set<Integer> numbersSet = new HashSet<>(numbers);

            are_all_constrains_met(numbers, numbersSet);

            this.numbers = numbers;
            this.numbersSet = numbersSet;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void are_all_constrains_met(List<Integer> numbers, Set<Integer> numbersSet)
            throws IllegalArgumentException {
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

    public static BaseballNumber getComputerPickedNumbers() {
        boolean hasException = true;

        BaseballNumber computerNumbers = null;
        while (hasException) {
            try {
                computerNumbers = new BaseballNumber
                        (Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
                hasException = false;
            } catch (IllegalArgumentException e) {

            }
        }
        return computerNumbers;
    }


    public boolean contains(int number) {
        return numbersSet.contains(number);
    }

    public boolean is_number_in_index_equal_to(int index, int num) {
        return numbers.get(index) == num;
    }

    public int get(int index) {
        return numbers.get(index);
    }

}
