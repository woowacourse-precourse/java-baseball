package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class User {

    private List<Integer> userNumbers;



    public List<Integer> userInputNumber() {
        String userInput = Console.readLine();
        userNumbers = string_User_NumtoInt_List(userInput);
        user_Input_Exception(userNumbers);
        return userNumbers;
    }

    public List<Integer> string_User_NumtoInt_List(String userInput) {
        String[] string_user_num = userInput.split("");
        List<Integer> int_user_list = new ArrayList<>();
        for (int i=0; i<userInput.length(); i++) {
            int_user_list.add(Integer.valueOf(string_user_num[i]));
        }
        return int_user_list;
    }

    public void user_Input_Exception(List<Integer> userNumber) {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("0을 제외한 서로 다른 세자리 숫자를 입력해주세요.");
        }
        if (userNumber.contains(0)) {
            throw new IllegalArgumentException("0을 제외한 서로 다른 세자리 숫자를 입력해주세요.");
        }
        for (int i = 0; i < userNumber.size(); i++) {
            if (Collections.frequency(userNumber, userNumber.get(i)) != 1) {
                throw new IllegalArgumentException("0을 제외한 서로 다른 세자리 숫자를 입력해주세요.");
            }
        }
    }

}
