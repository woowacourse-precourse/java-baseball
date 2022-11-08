package baseball.utils;

public class validation {
    public static boolean checkLength(String input){
        return input.length() == 3;
    }

    public static boolean checkNumber(String input){
        boolean checkInput = true;
        for(int i = 0; i< input.length(); i++){
            int num = input.charAt(i) - '0';
            if (num <= 0|| num > 9) {
                checkInput = false;
                break;
            }
        }
        return checkInput;
    }

    public static boolean userInputValidation(String input){
        return checkLength(input) && checkNumber(input);
    }

    public void startOrEndValidation(String inputNumber) {
        if(!(inputNumber.equals(1) || inputNumber.equals(2))) {
            throw new IllegalArgumentException();
        }
    }


}
