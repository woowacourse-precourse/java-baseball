package baseball.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    HashSet duplicateList;
    public InputValidator() {
    }

    public boolean checkValidateNumber(String number) {
        duplicateList = new HashSet<>();
        if(number.length() != 3) return false;
        String[] numberList = number.split("");
        Pattern pattern = Pattern.compile("[1-9]");
        for(int i = 0; i < 3; i++) {
            if(pattern.matcher(numberList[i]).matches() == false) return false;
            if(duplicateList.contains(numberList[i]) == true) return false;
            duplicateList.add(numberList[i]);
        }
        return true;
    }

    public boolean checkValidateExit(String number) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(number).matches();
    }

}
