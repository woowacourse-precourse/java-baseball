package baseball.util;

public class ValidationUtil {

    public static boolean ValidateInputNumber(String input) {
        if (input.length() == 3 || input.contains("0")
                || validateIsDigit(input)) {
        }
    }

    private static boolean validateIsDigit(String input) {
        char[] inputArray = input.toCharArray();
        for (char inputChar : inputArray) {
            if (Character.isDigit(inputChar)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateDuplicateNumber(String input){
        String[] strArray = input.split("");
        if (strArray[0].equals(strArray[1]) || strArray[0].equals(strArray[2])
                || strArray[1].equals(strArray[2])){
            return false;
        }
        return true;
    }


}

