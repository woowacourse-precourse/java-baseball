package baseball.validation;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;


public class InputNumber {
    public boolean inputNumberValidate(String numberString) {
        if (inputNumberOnlyNumber(numberString) && inputNumberLengthThree(numberString)) {
            if (inputNumberDuplicateCheck(numberString)) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean inputNumberOnlyNumber(String readLineNumber) {
        final String REGEX = "^[1-9]*$";
        return Pattern.matches(REGEX, readLineNumber);
    }

    private boolean inputNumberLengthThree(String readLineNumber) {
        if (readLineNumber.length() == 3) {
            return true;
        }
        return false;
    }

    private boolean inputNumberDuplicateCheck(String readLineNumber) {
        String[] numbers = readLineNumber.split("");
        Set<Integer> duplicateCheckSet = new HashSet<Integer>();
        for (String number : numbers) {
            duplicateCheckSet.add(Integer.parseInt(number));
        }
        if (duplicateCheckSet.size() == 3) {
            return true;
        }
        return false;
    }
}
