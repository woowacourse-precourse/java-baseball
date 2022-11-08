package baseball.utils;

import java.util.Arrays;

public class Validator {
    public boolean isValidString(String input) {
        return isRightLength(input) && isInteger(input) && isRightRange(input) && isDuplicate(input);
    }

    private boolean isInteger(String input){
        for (int i = 0; i < 3; i++)
            if (!Character.isDigit(input.charAt(i)))
                return false;
        return true;
    }
    private boolean isRightLength(String input) {
        return input.length() == 3;
    }

    private boolean isRightRange(String input) {
        for (int i = 0; i < 3; i++){
            int digit = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (digit == 0)
                return false;
        }
        return true;
    }

    private boolean isDuplicate(String input){
        return Arrays.stream(input.split(""))
                .distinct()
                .count() == input.length();
    }

    public boolean isRightNumber(String input) {
        if(isExitNumInteger(input)){
            int digit = Integer.parseInt(String.valueOf(input));
            if (digit == 1 || digit == 2)
                return true;
        }
        return false;
    }

    public boolean isExitNumInteger(String input) {
        char check;
        for(int i = 0; i<input.length(); i++){
            check = input.charAt(i);
            if(check < 48 || check > 58)
                return false;
        }
        return true;
    }
}
