package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> userNumber = new ArrayList<>();
    String userStringNumber;
    String[] splittedUserNumber;

    protected void scanUserNumber() {
        userNumber.clear();
        System.out.print("숫자를 입력해주세요 : ");
        userStringNumber = Console.readLine();
        if (userStringNumber.length() > 3 || userStringNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        splitStringNumber(userStringNumber);
    }

    protected void splitStringNumber(String userStringNumber) {
        splittedUserNumber = userStringNumber.split("");
        for (String s : splittedUserNumber) {
            userNumber.add(Integer.parseInt(s));
        }
    }
}
