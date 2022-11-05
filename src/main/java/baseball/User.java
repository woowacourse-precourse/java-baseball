package baseball;

import static baseball.Score.INPUT_LENGTH;
import static baseball.InputValidator.checkIsValidRestartExitString;
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
        String restartExitString;

        restartExitString = Console.readLine();
        checkIsValidRestartExitString(restartExitString);
        restartOrExitNumber = Integer.parseInt(restartExitString);
        return restartOrExitNumber;
    }

    public List<Integer> getInput() {
        return inputThreeNumbers;
    }
}
