package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;
import static constant.ErrorMessage.*;

public class UserInputNumbers {

    private List<Integer> addNumbers(String numbers) {
        List<Integer> userInputNumbers = new ArrayList<>();
        for (int idx = INITIAL_NUMBER; idx<NUMBER_LENGTH; idx++) {
            userInputNumbers.add(numbers.charAt(idx)-ZERO_ASCII);
        }
        return userInputNumbers;
    }

    public List<Integer> getUserInputNumbers() {
        String userInput = Console.readLine();
        validUserInputNumber(userInput);
        System.out.println(userInput);
        return addNumbers(userInput);
    }

    public static boolean validUserInputNumber(String numbers) {
        if (numbers.length()!=NUMBER_LENGTH) {
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

    public static boolean isValidDigit(String num) {
        for (int idx = INITIAL_NUMBER; idx<num.length(); idx++) {
            if (num.charAt(idx)<=ZERO_ASCII||num.charAt(idx)>NINE_ASCII) {
                return false;
            }
        }
        return true;
    }

    public static boolean duplicateNumber(String numbers) {
        for (int idx = INITIAL_NUMBER; idx<numbers.length(); idx++) {
            if (numberCount(numbers, numbers.charAt(idx))!=NOT_DUPLICATE_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static int numberCount(String numbers, char num) {
        return (int) numbers.chars()
                .filter(c -> c == num)
                .count();
    }
}
