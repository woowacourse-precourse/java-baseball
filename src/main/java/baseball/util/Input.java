package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String userInput;

    public Input() {}

    public void setUserInputByRead() {
        this.userInput = readUserInput();
        Validate.isAcceptAbleEndGame(userInput);
    }

    public String readUserInput() {
        return Console.readLine();
    }

    public String getUserInput() {
        return userInput;
    }
}
