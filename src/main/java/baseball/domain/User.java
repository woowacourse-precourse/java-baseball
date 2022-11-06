package baseball.domain;
import java.util.ArrayList;

import baseball.utils.Exceptions;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public static ArrayList<Integer> makeUserList() {
        //UserInput.getUserNumber();
        ArrayList<Integer> UserNumber = new ArrayList<>();
        String num = Console.readLine();
        Exceptions.isNumber(num);
        Exceptions.checkNumSize(num);
        for (int i = 0; i < 3; i++) {
            //아스키코드 '0'이 45임을 이용한다.
            UserNumber.add(num.charAt(i) - '0');
        }

        return UserNumber;
    }
}