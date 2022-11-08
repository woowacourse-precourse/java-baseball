package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
유저가 입력한 값 받아서 유효성 검사 하고 반환 해주는 곳
 */
public class UserNumber {

    public static List<Integer> getUserNumber(String userNumber) {
        int number = Integer.parseInt(userNumber);
        List<Integer> userNumberList = new ArrayList<>(Collections.emptyList());
        while (number > 0){
            userNumberList.add(number % 10);
            number /= 10;
        }
        return userNumberList;
    }

    public UserNumber(String userInput) {
        NumberCheckList.isIntegerCheck(userInput);
        NumberCheckList.isSizeCheck(userInput);
        NumberCheckList.isOverLapCheck(userInput);
    }

}
