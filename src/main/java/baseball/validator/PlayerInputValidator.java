package baseball.validator;

import baseball.view.SystemMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerInputValidator {

    public void checkPlayerInput(String input) {
        checkSizeOfInput(input);
        checkIsDigit(input);
        checkNumbersUnique(input);
    }

    public void checkResumeInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(SystemMessage.INPUT_IS_NOT_START_OR_STOP.getMessage());
        }
    }

    private void checkSizeOfInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(SystemMessage.INPUT_LENGTH_IS_NOT_THREE.getMessage());
        }
    }

    private void checkIsDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            int numericValue = Character.getNumericValue(input.charAt(i));
            if (numericValue > 9) {
                throw new IllegalArgumentException(SystemMessage.INPUT_IS_NOT_A_NUMBER.getMessage());
            }
        }
    }

    private void checkNumbersUnique(String input) {
        List<String> inputList = Arrays.asList(input.split(""));
        List<String> distinctList = Arrays.stream(input.split(""))
                .distinct()
                .collect(Collectors.toList());

        if (!distinctList.equals(inputList)) {
            throw new IllegalArgumentException(SystemMessage.INPUT_NUMBER_IS_NOT_UNIQUE.getMessage());
        }
    }
}
