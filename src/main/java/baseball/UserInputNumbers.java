package baseball;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class UserInputNumbers {
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
        if (!isValidDigit(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!duplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isValidDigit(String num) {
        for (int idx=START_IDX; idx<num.length(); idx++) {
            if (num.charAt(idx)<=ZERO_ASCII||num.charAt(idx)>NINE_ASCII) {
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
