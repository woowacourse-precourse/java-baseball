package baseball;

import constant.Const;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private int[] userNumber = new int[Const.NUMBER_LENGTH];
    String userInput;

    public int[] userNumber(){
        System.out.print(Const.USER_INPUT);

        userInput = Console.readLine();
        if (!isValidUserNumber()) {
            throw new IllegalArgumentException(Const.INPUT_WRONG);
        } else {
            userInputToNumber();
        }
        return userNumber;
    }

    private void userInputToNumber() {
        for (int i = 0; i < Const.NUMBER_LENGTH; i++) {
            this.userNumber[i] = Character.getNumericValue(userInput.charAt(i));
        }
    }

    private boolean isValidUserNumber() {
        return (isValidLength() && isRightRangeNumber() && isDuplicate());
    }

    private boolean isValidLength() {
        return (userInput.length() == Const.NUMBER_LENGTH);
    }

    private boolean isRightRangeNumber() {
        for (int i = 0; i < Const.NUMBER_LENGTH; i++){
            if (!isValidRangeNumber(i)){
                return false;
            }
        }
        return true;
    }

    private boolean isValidRangeNumber(int i) {
        return ('0' < userInput.charAt(i) && userInput.charAt(i) <= '9');
    }

    private boolean isDuplicate(){
        if (userInput.charAt(0) == userInput.charAt(1)) {
            return false;
        } else if (userInput.charAt(1) == userInput.charAt(2)) {
            return false;
        } else if (userInput.charAt(0) == userInput.charAt(2)) {
            return false;
        }

        return true;
    }
}
