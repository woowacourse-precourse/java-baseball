package baseball;

public class CheckException {
    private static final int LIMIT_LENGTH = 3;

    public static void validationNumber(String inputNum) {
        if (checkNumberLength(inputNum)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkNumberLength(String checkNum) {
        return checkNum.length() == LIMIT_LENGTH;
    }

}