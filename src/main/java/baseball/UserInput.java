package baseball;

import baseball.constant.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    private final static int MAX_NUMBER_SIZE = 3;

    int [] userNumber = new int[MAX_NUMBER_SIZE];
    String userInput;

    public int[] getUserInput() {
        System.out.println(Message.GAME_INPUT);
        userInput = Console.readLine();
        if(!validate()) throw new IllegalArgumentException();
        userInputToUserNumber();

        return userNumber;
    }

    public boolean validate(){
        return (checkLength() && checkDuplicate() && checkNumber());
    }

    public boolean checkLength(){
        return (userInput.length()==MAX_NUMBER_SIZE);
    }

    public boolean checkDuplicate(){
        boolean flag=true;
        if(userInput.charAt(0)==userInput.charAt(1)) flag=false;
        if(userInput.charAt(1)==userInput.charAt(2)) flag=false;
        if(userInput.charAt(2)==userInput.charAt(0)) flag=false;
        return flag;
    }

    public boolean checkNumber(){
        boolean flag=true;
        for(int i=0;i<MAX_NUMBER_SIZE;i++){
            if(!(userInput.charAt(i)>='1' && userInput.charAt(i)<='9')) flag=false;
        }
        return flag;
    }

    public void userInputToUserNumber(){
        for(int i=0;i<MAX_NUMBER_SIZE;i++){
            userNumber[i]=(userInput.charAt(i) - '0');
        }
    }

}
