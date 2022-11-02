package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputBallNumber {

    public String inputBallNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String ballNumbers = Console.readLine();
        return ballNumbers;
    }
}
