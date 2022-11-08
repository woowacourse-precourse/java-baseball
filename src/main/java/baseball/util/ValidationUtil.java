package baseball.util;

import baseball.controller.GameController;

public class ValidationUtil {

    public static boolean validateInputNumber(String input) {
        if (input.length()==3 && !input.contains("0")
                && validateIsDigit(input) && validateDuplicateNumber(input)) {
            return true;
        }
        return false;
    }

    private static boolean validateIsDigit(String input) {
        char[] inputArray = input.toCharArray();
        for (char inputChar : inputArray) {
            if (Character.isDigit(inputChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateDuplicateNumber(String input){
        String[] strArray = input.split("");
        if (strArray[0].equals(strArray[1]) || strArray[0].equals(strArray[2])
                || strArray[1].equals(strArray[2])){
            return false;
        }
        return true;
    }

    public static void validateInputRestart(String input){
        if (input.equals("1")){
            GameController gameController = new GameController();
            //gameController.startGame();
        }

        if (input.equals("2")){
            return;
        }

        throw new IllegalArgumentException();
    }


}

