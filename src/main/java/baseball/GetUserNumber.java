package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GetUserNumber {
    // scan user input
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userRandNumber = Console.readLine();
        System.out.println(userRandNumber);
        return userRandNumber;
    }

}
