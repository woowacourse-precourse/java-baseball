package baseball.validator;

import baseball.view.SystemMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerInputValidator {

    public List<Integer> getDigitList(String input) {
        List<Integer> digitList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int digit = changeToDigit(input.charAt(i));
            digitList.add(digit);
        }
        checkSizeOfInput(input);
        checkNumbersUnique(digitList);

        return digitList;
    }

    public void checkResumeInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(SystemMessage.INPUT_IS_NOT_START_OR_STOP.getMessage());
        }
    }

    private int changeToDigit(Character singleLetter) {
        int numericValue = Character.getNumericValue(singleLetter);
        checkIsDigit(numericValue);

        return numericValue;
    }

    private void checkIsDigit(int numericValue) {
        if (numericValue > 9) {
            throw new IllegalArgumentException(SystemMessage.INPUT_IS_NOT_A_NUMBER.getMessage());
        }
    }

    private void checkSizeOfInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(SystemMessage.INPUT_LENGTH_IS_NOT_THREE.getMessage());
        }
    }

    private void checkNumbersUnique(List<Integer> digitList) {
        List<Integer> distinctNumbers = digitList.stream()
                .distinct()
                .collect(Collectors.toList());

        if (!distinctNumbers.equals(digitList)) {
            throw new IllegalArgumentException(SystemMessage.INPUT_NUMBER_IS_NOT_UNIQUE.getMessage());
        }
    }
}
