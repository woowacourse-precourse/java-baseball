package baseball;

import Constant.Const;

import java.util.Scanner;

import static Constant.Const.NUMBER_LENGTH;

public class User {
    Scanner Scanner = new Scanner(System.in);
    int[] userNumber = new int[NUMBER_LENGTH];


    public void UserInput(){
        System.out.print(Const.USER_INPUT);

        String userInput = Scanner.nextLine();
        if (invalidUserNumber(userInput)) {
            throw new IllegalArgumentException(Const.INPUT_WRONG);
        } else {
            for (int i = 0; i < NUMBER_LENGTH; i++) {
                this.userNumber[i] = Character.getNumericValue(userInput.charAt(i));
            }
        }
    }

    private boolean invalidUserNumber(String userInput){
        if (userInput.length() != NUMBER_LENGTH){
            return true;
        }
        for (int i = 0; i < NUMBER_LENGTH; i++){
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
