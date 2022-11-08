package user;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static final int USER_INPUT_LENGTH = 3;

    public static List<Integer> getUser(){
        List<Integer> userInputList = new ArrayList<>();
        String userInput = Console.readLine();

        if(userInput.length()!=USER_INPUT_LENGTH){
            System.out.println("3개의 숫자를 입력해주세요!");
            throw new IllegalArgumentException();
        }else{
            for(int i=0; i<USER_INPUT_LENGTH;i++){
                int number = userInput.charAt(i) - '0';
                userInputList.add(number);
            }
        }
    }


}
