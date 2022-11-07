package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputValidator {

    private static final String VALIDATE_NUMBER_LENGTH_EXCEPTION = "3자리 수를 입력하세요.";
    private static final String VALIDATE_NUMBER_RANGE_EXCEPTION ="범위가 틀립니다. 1~9 사이의 수를 입력하세요";
    private static final String VALIDATE_NUMBER_DUPLICATE_EXCEPTION = "중복된 숫자입니다.";
    private static final String VALIDATE_NUMBER_RESTART_CODE_EXCEPTION = "1과 2 중 하나를 입력하세요.";


    public void validateNumber(String numbers) {
        if(!validateLengthOfNumber(numbers))
            throw new IllegalArgumentException(VALIDATE_NUMBER_LENGTH_EXCEPTION);

        if(!validateRangeOfNumber(numbers))
            throw new IllegalArgumentException(VALIDATE_NUMBER_RANGE_EXCEPTION);

        if(!checkDuplicateNumber(numbers))
            throw new IllegalArgumentException(VALIDATE_NUMBER_DUPLICATE_EXCEPTION);
    }

    private boolean validateLengthOfNumber(String numbers){
        if(numbers.length() != 3)
            return false;
        return true;
    }

    private boolean validateRangeOfNumber(String numbers) {
        for (char number : numbers.toCharArray()) {
            if(number <'1' || number > '9')
                return false;
        }
        return true;
    }

    private boolean checkDuplicateNumber(String numbers) {
        List<Character> check = new ArrayList<>();
        for (char number : numbers.toCharArray()) {
            if(check.contains(number))
                return false;
            check.add(number);
        }
        return true;
    }

    public void validateRestartCode(int restartCode){
        if(restartCode != 1 && restartCode != 2){
            throw new IllegalArgumentException(VALIDATE_NUMBER_RESTART_CODE_EXCEPTION);
        }
    }
}
