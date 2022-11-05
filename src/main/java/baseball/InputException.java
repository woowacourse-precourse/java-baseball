package baseball;

public class InputException {
    public static boolean checkLength(String number) {
        return number.length() == Constant.NUMBER_LENGTH;
    }

    public static boolean isAllNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
