package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class User {

    public List<Integer> userInputNumber() {
        String userInput = Console.readLine();
        List<Integer> user_Input_List = string_User_NumtoInt_List(userInput);
        return user_Input_List;
    }

    public List<Integer> string_User_NumtoInt_List(String userInput) {
        String[] string_user_num = userInput.split("");
        List<Integer> int_user_list = new ArrayList<>();
        for (int i=0; i<userInput.length(); i++) {
            int_user_list.add(Integer.valueOf(string_user_num[i]));
        }
        return int_user_list;
    }

}
