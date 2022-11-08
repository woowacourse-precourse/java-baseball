package baseball;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    boolean getNumberValidate(String numberString) {
        if (getNumberOnlyNumber(numberString) && getNumberLengthThree(numberString)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean getNumberOnlyNumber(String numberString) {
        final String REGEX = "^[1-9]*$";
        return Pattern.matches(REGEX, numberString);
    }

    private boolean getNumberLengthThree(String numberString) {
        if (numberString.length() == 3) {
            return true;
        }
        return false;
    }
}
