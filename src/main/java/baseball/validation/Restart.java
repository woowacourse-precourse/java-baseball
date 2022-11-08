package baseball.validation;

import java.util.regex.Pattern;

public class Restart {
    boolean validate(String restartValue) {
        if (lengthCheck(restartValue)) {
            return valueCheck(restartValue);
        } else {
            return false;
        }
    }

    private boolean lengthCheck(String restartValue) {
        if (restartValue.length() == 1) {
            return true;
        }
        return false;
    }

    private boolean valueCheck(String restartValue) {
        final String REGEX = "^[1-2]*$";
        return Pattern.matches(REGEX, restartValue);
    }
}
