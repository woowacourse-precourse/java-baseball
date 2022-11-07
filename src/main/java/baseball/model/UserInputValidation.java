package baseball.model;

import baseball.view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class UserInputValidation {
    private final static int USER_NUMBER_LENGTH = 3;

    //private String user_number;

    public List<Integer> getUserInput(String user_number) {
        isInputLengthValid(user_number);
        isInputDigit(user_number);
        isInputValueValid(user_number);

        return changeInputtoInt(user_number);
    }

    public boolean isInputLengthValid(String user_number) throws IllegalArgumentException {
        if (user_number.length() != USER_NUMBER_LENGTH)
            throw new IllegalArgumentException();
        return true;
    }

    public boolean isInputDigit(String user_number) throws IllegalArgumentException {
        for(int i = 0; i < USER_NUMBER_LENGTH; i++) {
            if(!Character.isDigit(user_number.charAt(i)))
                throw new IllegalArgumentException();
        }
        return true;
    }
    public boolean isInputValueValid(String user_number) throws IllegalArgumentException {
        if(user_number.contains("0")) throw new IllegalArgumentException();
        return true;
    }

    public List<Integer> changeInputtoInt(String user_number) {
        List<Integer> input_list = new ArrayList<>();
        for(int i = 0; i < USER_NUMBER_LENGTH; i++) {
            input_list.add(Character.getNumericValue(user_number.charAt(i)));
        }
        return input_list;
    }
}
