package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String userInput;

    public Input() {}

    public void setUserInputByRead() {
        String input = readUserInput();
        Validate.isAcceptAbleEndGame(input);
        this.userInput = input;
    }

    public String readUserInput() {
        return Console.readLine();
    }

    public String getUserInput() {
        return userInput;
    }
}
