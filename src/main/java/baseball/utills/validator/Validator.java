package baseball.utills.validator;

import java.util.Arrays;

public class Validator {

    public static boolean validateUserInput(String userInput) throws IllegalArgumentException{
        if (isThreelength(userInput) && isUnique(userInput) && isOnlyNumber(userInput)) return true;
        else throw new IllegalArgumentException();
    }

    public static boolean isThreelength(String userInput) {
        if (userInput.length() == 3) return true;
        else return false;
    }

    public static boolean isUnique(String userInput) {
        if (Arrays.stream(userInput.split("")).distinct().count() == 3) return true;
        else return false;
    }

    public static boolean isOnlyNumber(String userInput) {
        if ( Arrays.stream(userInput.split("")).filter(v -> v.charAt(0) < '1' || v.charAt(0) > '9').count() == 0) return true;
        else return false;
    }

    public static boolean validateOneOrTwo(String userInput) {
        if (isOneLength(userInput) && isOneOrTwo(userInput)) return true;
        else throw new IllegalArgumentException();
    }

    public static boolean isOneLength(String userInput) {
        if (userInput.length() == 1) return true;
        else return false;
    }

    public static boolean isOneOrTwo(String userInput) {
        if (userInput.charAt(0) == '1' || userInput.charAt(0) == '2') return true;
        else return false;
    }
}
