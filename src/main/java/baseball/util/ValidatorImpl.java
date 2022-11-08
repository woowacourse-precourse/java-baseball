package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class ValidatorImpl implements Validator {

    private final static int MAX_NUMBER_SIZE = 3;

    @Override
    public boolean validateDigit(String input) {
        for (char num : input.toCharArray()) {
            if (!Character.isDigit(num)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateLength(String input) {
        return input.length() == MAX_NUMBER_SIZE;
    }

    @Override
    public boolean validateDuplicate(String input) {
        List<Character> inputList = new ArrayList<>();

        for (char c : input.toCharArray()) {
            inputList.add(c);
        }

        return inputList.size() == inputList.stream().distinct().count();
    }

}
