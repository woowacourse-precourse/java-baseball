package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String getInput() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public int getChoice() {
        String choice = Console.readLine();
        return Integer.parseInt(choice);
    }

    public void validateInput(String input) {
        Exception.checkNumberFormatException(input);
        Exception.checkNumberLengthException(input)
        Exception.checkNumberRangeException(input);
        Exception.checkRepeatedNumberException(input);
    }
}
