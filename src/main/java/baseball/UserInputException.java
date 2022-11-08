package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserInputException {

    private static boolean checkLength(String inputNumber) {
        return inputNumber.length() == 3;
    }

    private static boolean isNumberValid(String inputNumber) {
        for (char digit : inputNumber.toCharArray()) {
            if (!Character.isDigit(digit)) return false;
            if (digit == '0') return false;
        }
        return true;
    }

    private static boolean isNumberDuplicated(String inputNumber) {
        Set<Character> numberSet = new HashSet<>();
        for (char digit : inputNumber.toCharArray()) {
            if (numberSet.contains(digit)) return false;
            numberSet.add(digit);
        }
        return true;
    }

    public static void checkUserInput(String inputNumber) {
        if (!checkLength((inputNumber))) {
            throw new IllegalArgumentException();
        }
        if (!isNumberValid(inputNumber)) {
            throw new IllegalArgumentException();
        }
        if (!isNumberDuplicated(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
