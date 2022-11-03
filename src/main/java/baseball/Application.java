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
    }

    public static boolean CheckInputLength(String input) {
        boolean isLengthCorrect = true;

        if(input.length() != 3) {
            isLengthCorrect = false;
        }

        return isLengthCorrect;
    }

    public static void ExceptionIfFalse(boolean isResultFalse)
            throws IllegalArgumentException {

        if(!isResultFalse) {
            throw new IllegalArgumentException();
        }
    }


}
