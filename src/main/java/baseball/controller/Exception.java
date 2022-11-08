package baseball.controller;

import java.util.HashSet;

public class Exception {
    static void validateAskRestartOrExitInput(String input, int GAME_RESTART, int GAME_EXIT, int GAME_RESTART_OR_EXIT_RESPONSE_LENGTH) {
        validateInputIsNumeric(input);
        validateInputLength(input, GAME_RESTART_OR_EXIT_RESPONSE_LENGTH);
        validateCorrectGameChoice(input, GAME_RESTART, GAME_EXIT);
    }
    static void validateUserInput(String input, int NUMBER_LENGTH){
        validateInputIsNumeric(input);
        validateInputLength(input, NUMBER_LENGTH);
        validateDuplicateNumber(input, NUMBER_LENGTH);
    }

    static void validateInputIsNumeric(String input){
        if(!input.matches("[0-9]+"))
            throw new IllegalArgumentException("숫자로 이루어진 입력이 아닙니다.");
    }
    static void validateInputLength(String input, int length){
        if(input.length() != length)
            throw new IllegalArgumentException("길이가 " + length + "인 숫자 입력이 아닙니다");
    }

    static void validateDuplicateNumber(String input, int NUMBER_LENGTH){
        HashSet<Integer> checkHastSet = new HashSet<>();
        for(int i=0; i<NUMBER_LENGTH; i++)
            checkHastSet.add(Integer.parseInt(input.substring(i,i+1)));
        if(checkHastSet.size() != NUMBER_LENGTH)
            throw new IllegalArgumentException("중복된 숫자가 포함된 숫자 입력입니다.");
    }
    static void validateCorrectGameChoice(String input, int GAME_RESTART, int GAME_EXIT){
        int intInput = Integer.parseInt(input);
        if(intInput != GAME_RESTART && intInput != GAME_EXIT)
            throw new IllegalArgumentException(GAME_RESTART + " 또는 " + GAME_EXIT + "의 입력이 아닙니다.");
    }
}
