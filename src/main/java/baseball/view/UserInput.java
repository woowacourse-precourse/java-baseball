package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private UserInput() {
    }

    public static UserInput getInstance() {
        return new UserInput();
    }

    public String input() {
        return Console.readLine();
    }
}
