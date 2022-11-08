package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static String getInputNumbersFromConsole() {
        Message.printInputNumbersMessage();
        String inputNumber = Console.readLine();

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
}
