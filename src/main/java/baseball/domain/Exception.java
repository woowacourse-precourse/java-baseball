package baseball.domain;

public class Exception {
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요.";

    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void checkNumberFormatException(String number) {
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e){
            throwException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
