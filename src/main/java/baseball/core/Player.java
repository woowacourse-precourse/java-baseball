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

import static baseball.util.BaseballConst.MAX_BALL_COUNT;

public class Player {

    private String inputString;

    public List<Integer> inputThreeNumbers(String inputString) throws BaseballException {
        this.inputString = inputString;
        List<Integer> threeNumbers = getThreeNumbers(inputString);
        validateIntegerList(threeNumbers);
        return threeNumbers;
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
        if (integerList.size() != MAX_BALL_COUNT) {
            throw new InputNumberOutOfRangeException(inputString);
        }
    }

    private void validateDuplicateNumber(Set<Integer> numSet, List<Integer> integerList) {
        if (numSet.size() != integerList.size()) {
            throw new DuplicateNumberException(inputString);
        }
    }

    public StatusCode inputStatusCode(String inputString) throws BaseballException {
        return StatusCode.from(inputString);
    }
}
