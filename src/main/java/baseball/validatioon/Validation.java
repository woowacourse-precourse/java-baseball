package baseball.validatioon;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Validation {

    public static boolean isValidNumber(int number, List<Integer> lst) {
        if (number < 1 || number > 9) {
            return false;
        }
        return !lst.contains(number);
    }

    public static void validateNumber(int number, List<Integer> lst){
        if(number <1 || number > 9){
            throw new IllegalArgumentException();
        }
        if(lst.contains(number)){
            throw new IllegalArgumentException();
        }
    }

    public static void validateCharIsDigit(char c){
        if(Character.isDigit(c)){
            throw new IllegalArgumentException();
        }
    }

    public static void validateOption(int number){
        if(number == 1 || number == 2){
            throw new IllegalArgumentException();
        }
    }

    public static void validateSize(String input, int size){
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    public static boolean isRestart(int restartOption){
        return restartOption == 1;
    }
}
