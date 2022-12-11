package baseball.view;

import baseball.util.Errors;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readString() {
        String inputString;
        inputString = Console.readLine();
        inputString = inputString.trim();
        validateBlank(inputString);
        return inputString.trim();
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

    private static void validateBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(Errors.INPUT_BLANK.getValue());
        }
    }
}
