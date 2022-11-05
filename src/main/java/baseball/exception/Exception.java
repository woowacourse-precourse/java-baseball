package baseball.exception;

public class Exception {
    public static void verifyNum(String number) {

        if(number.length() != 3) {
            throw new LogicException(ExceptionCode.NUMBER_LENGTH_IS_NOT_CORRECT);
        }
        if(number.charAt(0) == number.charAt(1) || number.charAt(1) == number.charAt(2) ||
                number.charAt(0) == number.charAt(2)) {
            throw new LogicException(ExceptionCode.NUMBER_ERROR);
        }
    }
}
