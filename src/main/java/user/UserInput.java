package user;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static final int USER_INPUT_LENGTH = 3;


    public static List<Integer> getUserInput(){
        List<Integer> userInputList = new ArrayList<>();
        try {
            String userInput = Console.readLine();

            if(userInput.length()!=USER_INPUT_LENGTH){
                System.out.println("3개의 숫자를 입력해주세요!");
                throw new IllegalArgumentException();
            }
            userInputList = changeUserInputToList(userInput);
        }catch (Exception e){};
        return userInputList;
    }

    public static List<Integer> changeUserInputToList(String userInput){
        List<Integer> userInputList = new ArrayList<>();
        for(int i=0; i<USER_INPUT_LENGTH;i++){
            int number = userInput.charAt(i) - '0';
            userInputList.add(number);
        }
        return userInputList;
    }

}
