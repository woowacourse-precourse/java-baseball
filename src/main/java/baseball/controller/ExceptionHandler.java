package baseball.controller;

public class ExceptionHandler {
    static void validateUserNumberOfString(String userNumberOfString) throws IllegalArgumentException{
        if (userNumberOfString.length() != 3) {
            throw new IllegalArgumentException("서로 다른 세 자리의 숫자를 입력해야 합니다.");
        }
    }

    static void validateOneIfGameRepeatOrTwo(String oneIfGameRepeatOrTwo) throws IllegalArgumentException{

    }
}
