package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Message.SET_USER_INPUT_NUMBER_MESSAGE;

/*
유저가 입력한 값 받아서 유효성 검사 하고 반환 해주는 곳
 */
public class UserNumber {

    public List<Integer> getUserNumber(String userNumber) {
        int number = Integer.parseInt(userNumber);
        List<Integer> userNumberList = new ArrayList<>();
        while (number > 0){
            userNumberList.add(number % 10);
            number /= 10;
        }
        return userNumberList;
    }

    public UserNumber() {
        getUserInput();
        String userNumber = getUserInput();
        NumberCheckList.isIntegerCheck(userNumber);
        NumberCheckList.isSizeCheck(userNumber);
        NumberCheckList.isOverLapCheck(userNumber);
    }
    public static String getUserInput(){
        System.out.println(SET_USER_INPUT_NUMBER_MESSAGE);

        return Console.readLine();
    }
}
