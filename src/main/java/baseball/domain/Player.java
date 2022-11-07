package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String getInput() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public void validateInput(String input) {
        Exception.checkNumberFormatException(input);
        Exception.checkNumberLengthException(input)
        Exception.checkNumberRangeException(input);
    }
}
