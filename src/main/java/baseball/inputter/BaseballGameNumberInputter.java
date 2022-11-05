package baseball.inputter;

import baseball.exception.DuplicateNumberException;
import baseball.exception.GameEachInputNumberOutOfRangeException;
import baseball.exception.GameInputNumberOutOfRangeException;
import baseball.exception.IllegalNumberInputException;
import baseball.exception.InputNumberFormatException;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGameNumberInputter {

    public static final int NUMBER_RANGE_SIZE = 3;
    private String inputString;
    
    public List<Integer> inputThreeNumbers() throws IllegalNumberInputException {
        inputString = input();
        List<Integer> integerList = getIntegerListByInputString();
        validateIntegerList(integerList);
        return integerList;
    }

    private String input() {
        return Console.readLine();
    }
    
    private List<Integer> getIntegerListByInputString() {
        List<String> splitInputList = toSplitList();
        return getIntegerList(splitInputList);
    }

    private List<String> toSplitList() {
        return List.of(inputString.split(""));
    }

    private List<Integer> getIntegerList(List<String> splitInputList) {
        List<Integer> integerList;
        try {
            integerList = splitInputList.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputNumberFormatException(inputString);
        }
        return integerList;
    }

    private void validateIntegerList(List<Integer> integerList) {
        Set<Integer> numSet = new HashSet<>(integerList);
        validateRange(numSet);
        validateDuplicateNumber(integerList);
    }

    private void validateRange(Set<Integer> numSet) {
        if (numSet.contains(0)) {
            throw new GameEachInputNumberOutOfRangeException(inputString);
        }
        if (numSet.size() != NUMBER_RANGE_SIZE) {
            throw new GameInputNumberOutOfRangeException(inputString);
        }
    }

    private void validateDuplicateNumber(List<Integer> integerList) {
        if (new HashSet<>(integerList).size() != integerList.size()) {
            throw new DuplicateNumberException(inputString);
        }
    }
}
