package baseball;

public class Validation {
    private static boolean isLength(String inputNum) {
        if (inputNum.length() != 3) {
            return false;
        }
        return true;
    }

    private static boolean isRange(String inputNum) {
        for (int i = 0; i < inputNum.length(); i++) {
            int number = Character.getNumericValue(inputNum.charAt(i));
            if (number < 1 || number > 10) {
                return false;
            }
        }
        return true;
    }


    private static boolean isDiff(String inputNum) {
        for (int i = 0; i < inputNum.length() - 1; i++) {
            if (inputNum.charAt(i) == inputNum.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String inputNum) {
        if (isDiff(inputNum) && isLength(inputNum) && isRange(inputNum)) {
            return true;
        }
        return false;
    }

}
