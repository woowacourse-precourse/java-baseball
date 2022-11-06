package baseball;

public class CheckException {
    private static final int LIMIT_LENGTH = 3;

    public static void validationNumber(String inputNum) {
        if (!(checkNumberLength(inputNum) && checkNumeric(inputNum))) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkNumberLength(String checkNum) {
        return checkNum.length() == LIMIT_LENGTH;
    }

    public static boolean checkNumeric(String checkNum) {
        try {
            Integer.parseInt(checkNum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

