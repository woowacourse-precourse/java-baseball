package baseball.service.validation;

import baseball.exception.IllegalInputException;
import baseball.exception.IllegalSizeException;
import baseball.exception.InputDuplicationException;
import baseball.exception.OutOfRangeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public void validateRange(List<Integer> list) {
        if (hasZero(list)) {
            throw OutOfRangeException.EXCEPTION;
        }
    }

    public boolean hasZero(List<Integer> list) {
        return list.stream()
            .anyMatch(it -> it == 0);
    }

    @Override
    public void validateNumberLength(int size, List<Integer> list) {
        if (list.size() != size) {
            throw IllegalSizeException.EXCEPTION;
        }
    }

    @Override
    public void validateDuplicate(List<Integer> list, int size) {
        list = list.stream()
            .distinct()
            .collect(Collectors.toList());

        if (list.size() < size) {
            throw InputDuplicationException.EXCEPTION;
        }
    }

    @Override
    public void validateIsNumber(String input) {
        Arrays.stream(input.split(""))
            .forEach(ValidationServiceImpl::isNumber);
    }

    private static void isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            throw IllegalInputException.EXCEPTION;
        }
    }
}
