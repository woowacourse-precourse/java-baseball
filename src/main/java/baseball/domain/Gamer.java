package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.exception.InputException.*;
import static baseball.util.Util.toList;

public class Gamer {
    public List<Integer> inputNumbers() {
        String inputNumbers = Console.readLine();
        validatesNumber(inputNumbers);
        return toList(inputNumbers);
    }

    public String inputReset() {
        String inputReset = Console.readLine();
        validatesResetNumber(inputReset);
        return inputReset;
    }
}
