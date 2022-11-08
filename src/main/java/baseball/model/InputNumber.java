package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputNumber {

    public static List<Integer> getValidNumberList() {
        String input = getPlayerInput();
        System.out.println("플레이어: " + input);
        validateInputSize(input);
        validateDigitRange(input);


        List<Integer> inputList = stringToList(input);
        validateUniqueNumberList(inputList);
        return inputList;
    }

    public static String getValidChoice() {
        String input = getPlayerInput();
        validateChoiceNumber(input);
        return input;
    }

    public static String getPlayerInput() {
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
            validateUniqueNumber(numberList, i);
        }
    }

    private static void validateUniqueNumber(List<Integer> numberList, int checkIndex) throws IllegalArgumentException {
        for (int i = 0; i < numberList.size(); i++) {
            if (checkIndex == i) {
                continue;
            }
            if (numberList.get(checkIndex) == numberList.get(i)) {
                throw new IllegalArgumentException("number is cannot duplicate.");
            }
        }
    }

    private static void validateInputSize(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("input has to be 3 length.");
        }
    }

    private static void validateDigitRange(String input) throws IllegalArgumentException {
        if (!Pattern.matches("^[1-9]*$", input)) {
            throw new IllegalArgumentException("digit range is a number of from 1 to 9.");
        }
    }

    private static void validateChoiceNumber(String input) throws IllegalArgumentException {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("only 1 or 2 number is possible.");
        }
    }
}
