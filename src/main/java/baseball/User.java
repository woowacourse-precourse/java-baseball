package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private String userInput;

    public void setUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        userInput = input;
    }
}
