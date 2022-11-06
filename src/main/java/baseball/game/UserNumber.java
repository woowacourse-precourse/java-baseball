package baseball.game;

import baseball.exception.UserNumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameMessage.INPUT_NUMBER_MESSAGE;

public class UserNumber {

    public static List<Integer> inputUserNumber(){
        System.out.println(INPUT_NUMBER_MESSAGE);
        String userNumber = Console.readLine();
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < userNumber.length(); i++)
            userNumberList.add(userNumber.charAt(i) - '0');
        return userNumberList;
    }

    public static List<Integer> checkInputUserNumber(){
        List<Integer> userNumberList = inputUserNumber();
        if(!UserNumberValidator.checkValidationUserNumber(userNumberList)){
            throw new IllegalArgumentException();
        }
        return userNumberList;
    }

}
