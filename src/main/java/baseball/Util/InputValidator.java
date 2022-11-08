package baseball.Util;

import java.util.List;

public class InputValidator {
    private static InputValidator inputValidator;
    private static final int NINIMUM_NUMBER = 111;
    private static final int MAXIMUM_NUMBER = 999;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (inputValidator == null) {
            inputValidator = new InputValidator();
        }
        return inputValidator;
    }
    public static boolean validate(String numbers) {
        try{
            int userInput = Integer.parseInt(numbers);
            validateSize(userInput);
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static void validateSize(int number) {
        if(number < NINIMUM_NUMBER || number > MAXIMUM_NUMBER){
            throw new IllegalArgumentException();
        }
    }

}
