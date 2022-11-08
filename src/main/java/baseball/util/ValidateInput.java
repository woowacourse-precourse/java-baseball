package baseball.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateInput {

    public List<Integer> validateInput(String input) {
        isValidateNumber(input);
        isValidateSize(input);
        List<Integer> inputList = inputToList(input);
        isValidateDuplicate(inputList);
        return inputList;
    }

    public void isValidateDuplicate(List<Integer> inputList) {
        Set<Integer> inputSet = new HashSet<>(inputList);
        List<Integer> setToList = new ArrayList<>(inputSet);
        if (setToList != inputList) {
            throw new IllegalStateException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    public void isValidateSize(String input) {
        if (input.length() != 3) {
            throw new IllegalStateException("세 자리의 숫자가 아닙니다.");
        }
    }

    public void isValidateNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("숫자가 아닌 값이 포함되어 있습니다");
        }
    }

    public List<Integer> inputToList(String input) {

        List<Integer> intList = new ArrayList<>();
        intList.add(input.charAt(0) - '0');
        intList.add(input.charAt(1) - '0');
        intList.add(input.charAt(2) - '0');
        return intList;
    }

}
