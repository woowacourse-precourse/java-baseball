package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private final String USER_Input_Message = "숫자를 입력해주세요 :";

    public String inputNumber() {
        System.out.println(USER_Input_Message);
        String names = Console.readLine();
        return names;
    }
}
