package baseball.controller;

import java.util.regex.Pattern;

public class InputValidator {
    public InputValidator() {
    }

    public boolean checkValidateNumber(String number) {
        if(number.length() != 3) return false;
    }

    public boolean checkValidateExit(String number) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(number).matches();
    }

}
