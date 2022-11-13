package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GetUserNumber {
    // scan user input
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userRandNumber = Console.readLine();
        if (userRandNumber.charAt(0) == userRandNumber.charAt(1)) {
            throw new IllegalArgumentException();
        } else if (userRandNumber.charAt(1) == userRandNumber.charAt(2)) {
            throw new IllegalArgumentException();
        } else if (userRandNumber.charAt(0) == userRandNumber.charAt(2)) {
            throw new IllegalArgumentException();
        } else if (userRandNumber.length() != 3) {
            throw new IllegalArgumentException();
        } else {
            return userRandNumber;
        }
    }

}
