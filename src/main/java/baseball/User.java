package baseball;

import static Constant.Const.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private int[] userNumber = new int[NUMBER_LENGTH];
    String userInput;

    public int[] UserInput(){
        System.out.print(USER_INPUT);

        userInput = readLine();
        if (!isValidUserNumber()) {
            throw new IllegalArgumentException(INPUT_WRONG);
        } else {
            for (int i = 0; i < NUMBER_LENGTH; i++) {
                this.userNumber[i] = Character.getNumericValue(userInput.charAt(i));
            }
        }
        return userNumber;
    }

    private boolean isValidUserNumber(){
        return (isValidLength() && isNumber() && isDuplicate());
    }

    private boolean isValidLength(){
        return (userInput.length() == NUMBER_LENGTH);
    }

    private boolean isNumber(){
        for (int i = 0; i < NUMBER_LENGTH; i++){
            if (!Character.isDigit(userInput.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(){
        return (userInput.charAt(0) != userInput.charAt(1)
                && userInput.charAt(1) != userInput.charAt(2) && userInput.charAt(0) != userInput.charAt(2));
    }
}
