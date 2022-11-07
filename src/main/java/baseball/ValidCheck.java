package baseball;

import java.util.HashMap;
import java.util.regex.Pattern;

public class ValidCheck {

    static void checkExceptionNumber(String inputNumber, HashMap<Integer, Integer> InputNumberHash) throws IllegalArgumentException {
        String pattern = "[1-9]{3}";
        if (!Pattern.matches(pattern, inputNumber)) {
            throw new IllegalArgumentException();
        }
        if (InputNumberHash.size()!=3) {
            throw new IllegalArgumentException();
        }
    }

    static void checkExceptionIsContinue(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.equals("1")||inputNumber.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
