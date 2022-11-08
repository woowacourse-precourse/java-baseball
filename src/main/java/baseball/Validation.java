package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;


public class Validation {
    boolean getNumberValidate(String numberString) {
        if (getNumberOnlyNumber(numberString) && getNumberLengthThree(numberString)) {
            if (getNumberDuplicateCheck(numberString)) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean getNumberOnlyNumber(String readLineNumber) {
        final String REGEX = "^[1-9]*$";
        return Pattern.matches(REGEX, readLineNumber);
    }

    private boolean getNumberLengthThree(String readLineNumber) {
        if (readLineNumber.length() == 3) {
            return true;
        }
        return false;
    }

    private boolean getNumberDuplicateCheck(String readLineNumber) {
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
