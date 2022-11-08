package baseball.controller;

import java.util.HashSet;

public class Exception {
    static void validateAskRestartOrExitInput(String input) {
        validateInputIsNumeric(input);
        validateInputLength(input, 1);
        validateCorrectGameChoice(input);
    }
    static void validateUserInput(String input){
        validateInputIsNumeric(input);
        validateInputLength(input, 3);
        validateDuplicateNumber(input);
    }

    static void validateInputIsNumeric(String input){
        if(!input.matches("[0-9]+"))
            throw new IllegalArgumentException("숫자로 이루어진 입력이 아닙니다.");
    }
    static void validateInputLength(String input, int length){
        if(input.length() != length)
            throw new IllegalArgumentException("길이가 " + length + "인 숫자 입력이 아닙니다");
    }

    static void validateDuplicateNumber(String input){
        HashSet<Integer> checkHastSet = new HashSet<>();
        for(int i=0; i<3; i++)
            checkHastSet.add(Integer.parseInt(input.substring(i,i+1)));
        if(checkHastSet.size() != 3)
            throw new IllegalArgumentException("중복된 숫자가 포함된 숫자 입력입니다.");
    }
    static void validateCorrectGameChoice(String input){
        if(!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException("1 또는 2의 입력이 아닙니다.");
    }
}
