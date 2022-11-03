package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputTest();
    }

    public static void InputTest() {
        String input = Console.readLine();
        System.out.println(input);

        ExceptionIfFalse(CheckInputLength(input));
        ExceptionIfFalse(CheckIsInputNumber(input));
    }

    public static boolean CheckInputLength(String input) {
        boolean isLengthCorrect = true;

        if(input.length() != 3) {
            isLengthCorrect = false;
        }

        return isLengthCorrect;
    }

    public static boolean ReturnFalseIfDupli(String input, int idxNumber) {
        for(int i = idxNumber + 1; i < input.length(); i++) {
            if(input.charAt(idxNumber) == input.charAt(i)) {
                return false;
            }
        }

        return true;
    }


    public static boolean CheckIsInputNumber(String input) {
        boolean isNumberCorrect = true;

        for(int i = 0; i < input.length(); i++) {
            if(!ReturnIsNumberDigit(input.charAt(i))) {
                isNumberCorrect = false;
                break;
            }
        }

        return isNumberCorrect;
    }

    public static boolean ReturnIsNumberDigit(char digit) {
        if(digit >= '1' && digit <= '9') {
            return true;
        }

        return false;
    }

    public static void ExceptionIfFalse(boolean isResultFalse)
            throws IllegalArgumentException {

        if(!isResultFalse) {
            throw new IllegalArgumentException();
        }
    }


}
