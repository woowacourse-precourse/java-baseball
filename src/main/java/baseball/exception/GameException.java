package baseball.exception;

import static baseball.exception.ErrorMessage.INPUT_SIZE;
import static baseball.exception.ErrorMessage.RUN_CODE;

public class GameException {
    private static final int INPUT_NUMBER_SIZE = 1;
    private static final int RESTART = 1;
    private static final int STOP = 2;

    public void runCodeLengthException(String runCode) throws IllegalArgumentException {
        if (runCode.length() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException(INPUT_SIZE.getErrorMessage());
        }
    }

    public void runCodeValidation(int runCode) throws IllegalArgumentException {
        if (runCode != RESTART && runCode != STOP) {
            throw new IllegalArgumentException(RUN_CODE.getErrorMessage());
        }
    }
}
