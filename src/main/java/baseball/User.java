package baseball;

import Constant.Const;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private int[] userNumber = new int[Const.NUMBER_LENGTH];
    String userInput;

    public int[] UserInput(){
        System.out.print(Const.USER_INPUT);

        userInput = Console.readLine();
        if (!isValidUserNumber()) {
            throw new IllegalArgumentException(Const.INPUT_WRONG);
        } else {
            for (int i = 0; i < Const.NUMBER_LENGTH; i++) {
                this.userNumber[i] = Character.getNumericValue(userInput.charAt(i));
            }
        }
        return userNumber;
    }

    private boolean isValidUserNumber() {
        return (isValidLength() && isNumber() && isWithinRange() && isDuplicate());
    }

    private boolean isWithinRange() {
        for (int i = 0; i < Const.NUMBER_LENGTH; i++){
            if (!('0' < userInput.charAt(i) && userInput.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }

    private boolean isValidLength() {
        return (userInput.length() == Const.NUMBER_LENGTH);
    }

    private boolean isNumber() {
        for (int i = 0; i < Const.NUMBER_LENGTH; i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
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
