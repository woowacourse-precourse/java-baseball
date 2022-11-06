package baseball.utils;

import java.util.List;

public class Validation {
    public static void validateSize(String input) {
        if (input.length() >3) {throwInputException();}
    }
    public static void validateArguments(char arg, List<Character> inputList) {
        if (!Character.isDigit(arg) | inputList.contains(arg)) {
            throwInputException();
        }
    }
    private static void throwInputException() {
        throw new IllegalArgumentException("3개의 서로 다른 숫자를 입력해주십시오");
    }

}
