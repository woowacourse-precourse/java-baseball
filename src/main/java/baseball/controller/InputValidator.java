package baseball.controller;

import java.util.HashSet;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String NUMBER_REGULAR_EXPRESSION = "[1-9]";
    private static final String EXIT_REGULAR_EXPRESSION = "[1-2]";
    private static final int INPUT_LENGTH = 3;
    private HashSet<String> duplicateList;

    public InputValidator() {
    }

    public boolean checkValidateNumber(String number) {
        duplicateList = new HashSet<>();
        if(number.length() != INPUT_LENGTH) return false;

        String[] numberList = number.split("");
        Pattern pattern = Pattern.compile(NUMBER_REGULAR_EXPRESSION);
        for(int i = 0; i < INPUT_LENGTH; i++) {
            if(pattern.matcher(numberList[i]).matches() == false) return false;
            if(duplicateList.contains(numberList[i]) == true) return false;
            duplicateList.add(numberList[i]);
        }
        return true;
    }

    public boolean checkValidateExit(String number) {
        Pattern pattern = Pattern.compile(EXIT_REGULAR_EXPRESSION);
        return pattern.matcher(number).matches();
    }

}
