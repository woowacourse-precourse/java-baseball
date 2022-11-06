package baseball.exception;

import static baseball.exception.ErrorMessage.NUMBER_SIZE;

public class GameException {
    private static final int INPUT_NUMBER_SIZE = 1;

    public void runCodeLengthException(String runCode) throws IllegalArgumentException {
        if (runCode.length() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    NUMBER_SIZE.getErrorMessage());
        }
    }
}
