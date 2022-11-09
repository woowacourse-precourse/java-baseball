package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("입력한 수가 3글자가 아님");
        }
        if (userNumber.contains("0")){
            throw new IllegalArgumentException("입력한 수에 0이 포함");
        }
        return userNumber;
    }

}
