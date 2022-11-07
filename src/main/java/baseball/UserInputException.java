package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputException {
    public UserInputException() {
    }

    // 아래의 예외처리들을 하나의 메소드로 검사
    public boolean checkAllCondition(String inputString){
        if (checkIfInputIsThreeDigit(inputString)
                && checkInputIsInteger(inputString)
                && checkZeroAtInput(inputString)
                && checkAllDigitDifference(inputString)){
            return true;
        }
        else
            return false;
    }

    // 입력받은 자릿수가 세자리가 아니라면 false 리턴
    private boolean checkIfInputIsThreeDigit(String inputString) {
        return inputString.length() == 3;
    }

    // 입력받은 값이 정수가 아니라면 false 리턴
    private boolean checkInputIsInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // 입력받은 값 중에 0이 있다면 false 리턴
    private boolean checkZeroAtInput(String input){
        for (int i = 0; i < 3; i++){
            if (input.charAt(i) == '0'){
                return false;
            }
        }
        return true;
    }

    // 입력받은 값 중에 겹치는 값이 있다면 false 리턴
    private boolean checkAllDigitDifference(String input){
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            int term = (int)input.charAt(i);
            if (!numberList.contains(term)){
                numberList.add(term);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
