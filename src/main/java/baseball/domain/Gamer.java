package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.exception.InputException.*;
import static baseball.util.Util.toIntArray;
import static baseball.util.Util.toList;

public class Gamer {
    public List<Integer> inputNumbers() {
        String inputNumbers = Console.readLine();
        validatesNumber(inputNumbers);
        int[] numbers = toIntArray(inputNumbers);
        return toList(numbers);
    }

    public String inputReset() {
        String inputReset = Console.readLine();
        isNumber(inputReset);
        return inputReset;
    }
}
