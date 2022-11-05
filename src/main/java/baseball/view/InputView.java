package baseball.view;

import static baseball.view.InputValidator.checkIsValidRestartExitString;
import static baseball.view.InputValidator.checkIsValidThreeNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static List<Integer> inputGuessThreeNumbers() {
        OutputView.printInputHint();
        String inputNumbers = Console.readLine();
        checkIsValidThreeNumbers(inputNumbers);
        return stringToList(inputNumbers);
    }

    private static List<Integer> stringToList(String inputNumbers) {
        List<Integer> inputThreeNumbers = new ArrayList<>();
        for (char c : inputNumbers.toCharArray()) {
            inputThreeNumbers.add(c - '0');
        }
        return inputThreeNumbers;
    }

    public static int inputRestartOrExitNumber() {
        OutputView.printRestartOrExit();
        String restartExitString = Console.readLine();
        checkIsValidRestartExitString(restartExitString);
        return Integer.parseInt(restartExitString);
    }
}
