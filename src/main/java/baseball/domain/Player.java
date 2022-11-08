package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String getInput() {
        String input = Console.readLine();
        Validator.validateInput(input);
        return input;
    }

    public int getChoice() {
        String choice = Console.readLine();
        Validator.validateChoice(choice);
        return Integer.parseInt(choice);
    }
}
