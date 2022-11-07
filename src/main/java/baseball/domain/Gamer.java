package baseball.domain;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.util.Util.toIntArray;
import static baseball.util.Util.toList;

public class Gamer {
    public List<Integer> inputNumbers() {
        String inputNumbers = Console.readLine();

        InputException.isNumber(inputNumbers);
        InputException.isLength(inputNumbers);
        InputException.isDuplicate(inputNumbers);

        int[] numbers = toIntArray(inputNumbers);
        return toList(numbers);
    }

    public String inputReset() {
        String inputReset = Console.readLine();
        InputException.isNumber(inputReset);
        return inputReset;
    }
}
