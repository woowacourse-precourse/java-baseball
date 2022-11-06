package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerInput {

    public List<Integer> ReturnPlayerNum(String inputPlayer) {

        CheckAllIllegalArgumentException(inputPlayer);
        List<String> inputStr = ChangeStringToList(inputPlayer);
        List<Integer> inputIntLIst = ChangeStrListToNumList(inputStr);

        return inputIntLIst;
    }

    private List<String> ChangeStringToList(String input) {

        return Arrays.asList(input.split(""));
    }

    private List<Integer> ChangeStrListToNumList(List<String> inputListStr) {

        return inputListStr.stream()
                .map(str -> Integer.parseInt(str))
                .collect(Collectors.toList());
    }

    private void CheckAllIllegalArgumentException(String input) {

        ExceptionIfFalse(CheckInputLength(input));
        // 길이 체크
        ExceptionIfFalse(CheckIsInputNumber(input));
        // 숫자인지 체크
        ExceptionIfFalse(CheckIsNumberDupli(input));
        // 중복 체크
    }

    private boolean CheckInputLength(String input) {
        boolean isLengthCorrect = true;

        if(input.length() != 3) {
            isLengthCorrect = false;
        }

        return isLengthCorrect;
    }

    private boolean CheckIsNumberDupli(String input) {
        boolean isNotDuplication = true;

        for(int i = 0; i < input.length()-1; i++) {
            if(!ReturnFalseIfDupli(input, i)){
                isNotDuplication = false;
            }
        }

        return isNotDuplication;
    }

    private boolean ReturnFalseIfDupli(String input, int idxNumber) {
        for(int i = idxNumber + 1; i < input.length(); i++) {
            if(input.charAt(idxNumber) == input.charAt(i)) {
                return false;
            }
        }

        return true;
    }


    private boolean CheckIsInputNumber(String input) {
        boolean isNumberCorrect = true;

        for(int i = 0; i < input.length(); i++) {
            if(!ReturnIsNumberDigit(input.charAt(i))) {
                isNumberCorrect = false;
                break;
            }
        }

        return isNumberCorrect;
    }

    private boolean ReturnIsNumberDigit(char digit) {
        if(digit >= '1' && digit <= '9') {
            return true;
        }

        return false;
    }

    private void ExceptionIfFalse(boolean isResultFalse)
            throws IllegalArgumentException {

        if(!isResultFalse) {
            throw new IllegalArgumentException();
        }
    }
}
