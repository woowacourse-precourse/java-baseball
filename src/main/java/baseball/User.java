package baseball;

import static baseball.Compare.INPUT_LENGTH;
import static baseball.InputValidator.checkIsValidThreeNumbers;

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
        String inputNumbers = Console.readLine();
        checkIsValidThreeNumbers(inputNumbers);
        stringToList(inputNumbers);
        return inputThreeNumbers;
    }

    private void stringToList(String inputNumbers) {
        for (int i = 0; i < INPUT_LENGTH; i++) {
            inputThreeNumbers.add(Integer.parseInt(inputNumbers.substring(i, i + 1)));
        }
    }

    public int inputRestartOrExitNumber() {
        restartOrExitNumber = Integer.parseInt(Console.readLine());
        return restartOrExitNumber;
    }

    public List<Integer> getInput() {
        return inputThreeNumbers;
    }
}
