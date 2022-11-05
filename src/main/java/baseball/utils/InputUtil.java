package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InputUtil {

    public InputUtil() {
    }

    public ArrayList<Integer> inputUserNumbers() {
        System.out.print(Constant.INPUT_NUMBER.getMessage());
        String numbers = Console.readLine();
        ArrayList<Integer> userNumbers = parseStringToInt(numbers);
        System.out.println();
        return userNumbers;
    }

    public ArrayList<Integer> parseStringToInt(String numbers) {
        checkLength(numbers, 3, Constant.NUMBER_LENGTH_EXCEPTION.getMessage());
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            checkIsDigit(numbers.charAt(i), Constant.ISDIGIT_EXCEPTION.getMessage());
            int number = charToInt(numbers.charAt(i));
            checkValidNumber(number, Constant.MIN_NUM.getNumber(), Constant.MAX_NUM.getNumber(),
                    Constant.VALID_NUMBER_EXCEPTION.getMessage());
            checkDuplicationNumber(inputNumbers, number);
            inputNumbers.add(number);
        }
        return inputNumbers;
    }

    public void checkIsDigit(char number, String exception) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(exception);
        }
    }

    public void checkDuplicationNumber(ArrayList<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(Constant.DUPLICATION_EXCEPTION.getMessage());
        }
    }

    public void checkValidNumber(int number, int minNumber, int maxNumber, String exception) {
        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException(exception);
        }
    }

    public void checkLength(String number, int length, String exception) {
        if (number.length() != length) {
            throw new IllegalArgumentException(exception);
        }
    }

    public int charToInt(char number) {
        return Integer.parseInt(String.valueOf(number));
    }
}
