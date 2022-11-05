package baseball.view;

import camp.nextstep.edu.missionutils.Console;


public class UserInput {
    public String input() {
        return Console.readLine();
    }

    public void validateContinueInput(String inputContinueGame) {
        String pattern = "[1-2]";
        if (!inputContinueGame.matches(pattern)) {
            throw new IllegalArgumentException();
        }
    }
}
