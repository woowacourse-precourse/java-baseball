package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    static final String RESTART = "1";
    static final String END = "2";

    public static String getInputNumbersFromConsole() {
        Message.printInputNumbersMessage();
        String inputNumber = Console.readLine();

        InputValidator.validateInputNumber(inputNumber);

        return inputNumber;
    }

    public List<Integer> getInputNumberAsList() {
        String inputNumbersString = getInputNumbersFromConsole();
        List<Integer> inputNumbersList = new ArrayList<>();

        for (int i = 0; i < inputNumbersString.length(); i++) {
            inputNumbersList.add(inputNumbersString.charAt(i) - '0');
        }

        return inputNumbersList;
    }

    public static boolean getRestartOrEnd() {
        Message.printRestartOrEndMessage();

        boolean wantRestart = false;

        String inputRestartOrEnd = Console.readLine();

        if (inputRestartOrEnd.equals(RESTART)) {
            wantRestart = true;
        }

        if (inputRestartOrEnd.equals(END)) {
            wantRestart = false;
        }

        return wantRestart;
    }
}
