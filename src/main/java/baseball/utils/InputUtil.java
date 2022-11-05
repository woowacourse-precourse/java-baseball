package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InputUtil {

    public InputUtil() {
    }

    public void inputUserNumbers() {
        System.out.print(ConstantMessage.INPUT_NUMBER.getConstant());
        String numbers = Console.readLine();
        ArrayList<Integer> userNumbers = parseStringToInt(numbers);
        System.out.println();
    }

    public ArrayList<Integer> parseStringToInt(String numbers) {
        checkLength(numbers, 3);
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            checkIsDigit(numbers.charAt(i));
            int number = charToInt(numbers.charAt(i));
            checkValidNumber(number, MIN_NUM, MAX_NUM);
            checkDuplicationNumber(inputNumbers, number);
            inputNumbers.add(number);
        }
        return inputNumbers;
    }

    public void checkIsDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(ConstantMessage.ISDIGIT_EXCEPTION.getConstant());
        }
    }

    public void checkDuplicationNumber(ArrayList<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ConstantMessage.DUPLICATION_EXCEPTION.getConstant());
        }
    }

    public void checkValidNumber(int number, int minNumber, int maxNumber) {
        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException(ConstantMessage.VALID_NUMBER_EXCEPTION.getConstant());
        }
    }

    public void checkLength(String number, int length) {
        if (number.length() != length) {
            throw new IllegalArgumentException(ConstantMessage.NUMBER_LENGTH_EXCEPTION.getConstant());
        }
    }

    public int charToInt(char number) {
        return Integer.parseInt(String.valueOf(number));
    }
}
