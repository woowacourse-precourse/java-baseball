package baseball.core;

import baseball.exception.BaseballException;
import baseball.exception.DuplicateNumberException;
import baseball.exception.EachInputNumberOutOfRangeException;
import baseball.exception.InputNumberFormatException;
import baseball.exception.InputNumberOutOfRangeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {

    public static final int NUMBER_RANGE_SIZE = 3;

    private List<Integer> threeNumbers;
    private String inputString;

    public void inputThreeNumbers(String inputString) throws BaseballException {
        this.inputString = inputString;
        this.threeNumbers = getThreeNumbers(inputString);
        validateIntegerList(threeNumbers);
    }

    private List<Integer> getThreeNumbers(String inputString) {
        try {
            return Stream.of(inputString.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputNumberFormatException(inputString);
        }
    }

    private void validateIntegerList(List<Integer> integerList) {
        Set<Integer> numSet = new HashSet<>(integerList);
        validateEachNumberRange(numSet);
        validateRange(integerList);
        validateDuplicateNumber(numSet, integerList);
    }

    private void validateEachNumberRange(Set<Integer> numSet) {
        if (numSet.contains(0)) {
            throw new EachInputNumberOutOfRangeException(inputString);
        }
    }

    private void validateRange(List<Integer> integerList) {
        if (integerList.size() != NUMBER_RANGE_SIZE) {
            throw new InputNumberOutOfRangeException(inputString);
        }
    }

    private void validateDuplicateNumber(Set<Integer> numSet, List<Integer> integerList) {
        if (numSet.size() != integerList.size()) {
            throw new DuplicateNumberException(inputString);
        }
    }

    public List<Integer> sayThreeNumbers() {
        return threeNumbers;
    }

    public StatusCode inputStatusCode(String inputString) throws BaseballException {
        return StatusCode.from(inputString);
    }
}
