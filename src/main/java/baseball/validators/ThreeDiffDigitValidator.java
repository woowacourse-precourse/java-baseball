package baseball.validators;

import java.util.ArrayList;
import java.util.List;

public class ThreeDiffDigitValidator {

    public void validate(String input) {
        checkLengthThree(input);
        checkInteger(input);
        checkDiffDigit(input);
    }

    private void checkLengthThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDiffDigit(String input) {
        List<Character> charList = new ArrayList<>();
        for (Character ch:
                input.toCharArray()) {
            charList.add(ch);
        }
        long distinctInputLength = charList.stream().distinct().count();

        if (distinctInputLength != input.length()) {
            throw new IllegalArgumentException();
        }
    }

}
