package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> inputThreeNumbers;
    int restartOrExitNumber;

    public User() {
    }

    public List<Integer> inputGuessRandomNumbers() {
        inputThreeNumbers = new ArrayList<>();
        int inputNumbers = Integer.parseInt(Console.readLine());
        return inputThreeNumbers;
    }

    public int inputRestartOrExitNumber() {
        restartOrExitNumber = Integer.parseInt(Console.readLine());
        return restartOrExitNumber;
    }

    public List<Integer> getInput() {
        return inputThreeNumbers;
    }
}
