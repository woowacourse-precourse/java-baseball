package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public boolean isDigit(char digit) {
        return digit >= '1' && digit <= '9';
    }
}
