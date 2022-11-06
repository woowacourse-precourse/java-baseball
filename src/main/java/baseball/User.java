package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        verifyInput(input);
    }

    public void verifyInput (String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 수가 3자리가 아닙니다.");
        }
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("입력한 수가 1-9가 아닙니다.");
        }
    }
}
