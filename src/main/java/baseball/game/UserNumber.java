package baseball.game;

import baseball.exception.UserNumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    /**
     * 사용자 수 생성
     */
    public static List<Integer> inputUserNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < userNumber.length(); i++)
            userNumberList.add(userNumber.charAt(i) - '0');
        return userNumberList;
    }

    /**
     * 사용자 수 검증 함수 호출
     */
    public static List<Integer> checkInputUserNumber(){
        List<Integer> userNumberList = inputUserNumber();
        if(!UserNumberValidator.checkValidationUserNumber(userNumberList)){
            throw new IllegalArgumentException();
        }
        return userNumberList;
    }

}
