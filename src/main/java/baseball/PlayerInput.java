package baseball;


import java.util.Arrays;
import java.util.List;

public class PlayerInput {

    public List<String> ChangeStringToList(String input) {
        List<String> inputStringList = Arrays.asList(input.split(""));
        return inputStringList;
    }
    public void InputTest(String input) {

        ExceptionIfFalse(CheckInputLength(input));
        // 길이 체크
        ExceptionIfFalse(CheckIsInputNumber(input));
        // 숫자인지 체크
        ExceptionIfFalse(CheckIsNumberDupli(input));
        // 중복 체크
    }

    public boolean CheckInputLength(String input) {
        boolean isLengthCorrect = true;

        if(input.length() != 3) {
            isLengthCorrect = false;
        }

        return isLengthCorrect;
    }

    public boolean CheckIsNumberDupli(String input) {
        boolean isNotDuplication = true;

        for(int i = 0; i < input.length()-1; i++) {
            if(!ReturnFalseIfDupli(input, i)){
                isNotDuplication = false;
            }
        }

        return isNotDuplication;
    }

    public boolean ReturnFalseIfDupli(String input, int idxNumber) {
        for(int i = idxNumber + 1; i < input.length(); i++) {
            if(input.charAt(idxNumber) == input.charAt(i)) {
                return false;
            }
        }

        return true;
    }


    public boolean CheckIsInputNumber(String input) {
        boolean isNumberCorrect = true;

        for(int i = 0; i < input.length(); i++) {
            if(!ReturnIsNumberDigit(input.charAt(i))) {
                isNumberCorrect = false;
                break;
            }
        }

        return isNumberCorrect;
    }

    public boolean ReturnIsNumberDigit(char digit) {
        if(digit >= '1' && digit <= '9') {
            return true;
        }

        return false;
    }

    public void ExceptionIfFalse(boolean isResultFalse)
            throws IllegalArgumentException {

        if(!isResultFalse) {
            throw new IllegalArgumentException();
        }
    }
}
