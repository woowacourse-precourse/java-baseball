package baseball.utils;

public class InputValidation {
    public static void validationNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }

        if(!isNumeric(input)){
            throw new IllegalArgumentException();
        }

    }

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
