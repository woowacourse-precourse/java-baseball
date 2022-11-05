package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    public List<Integer> inputUserNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < userNumber.length(); i++)
            userNumberList.add(userNumber.charAt(i) - '0');
        return userNumberList;
    }

}
