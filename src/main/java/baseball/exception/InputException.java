package baseball.exception;

public class InputException {

    private static final int LENGTH = 3;

    public static void userInputValidationCheck(String input){
        if(isThreeLength(input) && isInteger(input)){
            return;
        }
        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }

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
