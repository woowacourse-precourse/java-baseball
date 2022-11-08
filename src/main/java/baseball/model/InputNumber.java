package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    public static List<Integer> getValidNumberList() {
        String input = getPlayerInput();
        Exception.validateInputSize(input);
        Exception.validateDigitRange(input);

        List<Integer> inputList = stringToList(input);
        validateUniqueNumberList(inputList);
        return inputList;
    }

    public static String getValidChoice() {
        String input = getPlayerInput();
        Exception.validateChoiceNumber(input);
        return input;
    }

    private static String getPlayerInput() {
        return Console.readLine();
    }

    private static List<Integer> stringToList(String input) {
        List<Integer> inputList = new ArrayList<>();
        String[] splitInput = input.split("");
        for (int i = 0; i < input.length(); i++) {
            inputList.add(Integer.valueOf(splitInput[i]));
        }
        return inputList;
    }

    private static void validateUniqueNumberList(List<Integer> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            Exception.validateUniqueNumber(numberList, i);
        }
    }
}
