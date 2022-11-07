package baseball.domain.view;

import baseball.domain.exception.InputNumberException;
import baseball.domain.util.Util;
import baseball.domain.util.InputNumbersConstants;

public class InputView {
    private static final String inputNumbers = InputNumbersConstants.PLEASE_INPUT_NUMBER;

    public static String printNumbers() {
        System.out.print(inputNumbers);
        String input = Util.input();
        InputNumberException.inputNumberVerifier(input);
        return input;
    }
}
