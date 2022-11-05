package baseball;

import Constant.Const;

import java.util.Scanner;

public class User {
    Scanner Scanner = new Scanner(System.in);
    int[] userNumber = new int[3];


    public void UserInput(){
        System.out.print(Const.USER_INPUT);

        String userInput = Scanner.nextLine();
        if (invalidUserNumber(userInput)) {
            throw new IllegalArgumentException(Const.INPUT_WRONG);
        } else {
            for (int i = 0; i < 3; i++) {
                this.userNumber[i] = Character.getNumericValue(userInput.charAt(i));
            }
        }
    }

    private boolean invalidUserNumber(String userInput){
        // 3자리인지, 중복이 없는지, 1-9 사이의 값이 맞는지
        if (userInput.length() != 3){
            return true;
        }
        for (int i = 0; i < 3; i++){
            if (!Character.isDigit(userInput.charAt(i))){
                return true;
            }
        }
        if (userInput.charAt(0) == userInput.charAt(1) || userInput.charAt(1) == userInput.charAt(2) || userInput.charAt(0) == userInput.charAt(2)){
            return true;
        }
        return false;
    }

    public int[] getUserNumber(){
        return userNumber;
    }
}
