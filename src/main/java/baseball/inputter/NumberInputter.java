package baseball.inputter;

import baseball.exception.IllegalNumberInputException;
import camp.nextstep.edu.missionutils.Console;

public class NumberInputter {

    public Integer input() {
        String inputString = Console.readLine();

        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalNumberInputException(inputString);
        }
    }
}
