package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    String userNumbers;

    Baseball() {}

    private void setUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        userNumbers = Console.readLine();
        System.out.println();
    }
}
