package baseball.exception;

public class InputException {

    private static final int LENGTH = 3;

    private static boolean isThreeLength(String input){
        return input.length() == LENGTH;
    }

    private static boolean isInteger(String input) {
        for (int i = 0; i < LENGTH; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
