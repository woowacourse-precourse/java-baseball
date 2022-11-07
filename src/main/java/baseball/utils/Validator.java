package baseball.utils;

import java.util.Arrays;

public class Validator {
    public boolean isValidString(String input) {
        return isRightLength(input) && isRightRange(input) && isDuplicate(input);
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
}
