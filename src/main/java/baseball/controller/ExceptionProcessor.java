package baseball.controller;

public class ExceptionProcessor {
    private static final int NUMBER_LENGTH = 3;
    private static final String RESTART = "1";
    private static final String END = "2";

    public static void checkThreeNumbersValid(String data) {
        if (isValidLength(data) && haveDifferentNumbers(data)) {
            return;
        }
        throw new IllegalArgumentException();// TODO: 책 읽어보고 수정하기
    }

    private static boolean isValidLength(String data) {
        if (data.length() == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean haveDifferentNumbers(String data) {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (!isNumber(data.charAt(index))) {
                return false;
            }
            int comparedIndex = (index + 1) % NUMBER_LENGTH;
            if (data.charAt(index) == data.charAt(comparedIndex)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(char character) {
        if ('1' <= character && character <= '9') {
            return true;
        }
        return false;
    }

    public static void checkRestartCondition(String data) {
        if (RESTART.equals(data) || END.equals(data)) {
            return;
        }
        throw new IllegalArgumentException(); //TODO : 예외 발생 수정하기
    }
}
