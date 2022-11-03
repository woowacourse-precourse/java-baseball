package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputNumbers {
    static final int NUMBER_LENGTH = 3;
    static final int START_IDX = 0;
    static final int NOT_DUPLICATE_NUMBER = 1;
    static final char ZERO_ASCII = '0';

    private List<Integer> userInputNumbers = new ArrayList<>();

    public UserInputNumbers(String numbers) {
        if(validUserInputNumber(numbers)){
            addNumbers(numbers);
        }
    }

    private void addNumbers(String numbers) {
        for (int idx=START_IDX; idx<NUMBER_LENGTH; idx++) {
            userInputNumbers.add(numbers.charAt(idx)-ZERO_ASCII);
        }
    }

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }

    public static boolean validUserInputNumber(String numbers) {
        if (numbers.length()!=NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (!isDigit(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!duplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isDigit(String num) {
        for (int idx=START_IDX; idx<num.length(); idx++) {
            if (!Character.isDigit(num.charAt(idx))) {
                return false;
            }
        }
        return true;
    }

    public static boolean duplicateNumber(String numbers) {
        for (int idx=START_IDX; idx<numbers.length(); idx++) {
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
