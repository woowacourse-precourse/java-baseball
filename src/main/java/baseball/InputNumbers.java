package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;
import static constant.ErrorMessage.*;

public class InputNumbers {

    public static List<Integer> getInputNumbers() {
        String userInput = Console.readLine();
        validInputNumber(userInput);
        System.out.println(userInput);
        return makeList(userInput);
    }

    private static List<Integer> makeList(String userInput) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (int idx = INITIAL_NUMBER; idx < NUMBER_LENGTH; idx++) {
            inputNumbers.add(userInput.charAt(idx) - ZERO_ASCII);
        }
        return inputNumbers;
    }

    public static String getControlNumber() {
        String userInput = Console.readLine();
        validInputControl(userInput);
        System.out.println(userInput);
        return userInput;
    }

    private static boolean validInputNumber(String numbers) {
        if (numbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_RADIX);
        }
        if (!isValidDigit(numbers)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE);
        }
        if (!duplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_VALUE);
        }
        return true;
    }

    private static void validInputControl(String num) {
        if (!num.equals(RESTART) && !num.equals(END)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE);
        }
    }

    private static boolean isValidDigit(String num) {
        for (int idx = INITIAL_NUMBER; idx < num.length(); idx++) {
            if (num.charAt(idx) <= ZERO_ASCII || num.charAt(idx) > NINE_ASCII) {
                return false;
            }
        }
        return true;
    }

    private static boolean duplicateNumber(String numbers) {
        for (int idx = INITIAL_NUMBER; idx < numbers.length(); idx++) {
            if (numberCount(numbers, numbers.charAt(idx)) != NOT_DUPLICATE_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private static int numberCount(String numbers, char num) {
        return (int) numbers.chars()
                .filter(c -> c == num)
                .count();
    }
}
