package baseball.console.converter;

import baseball.console.exception.InputNumberFormatException;
import baseball.console.exception.InvalidStatusCodeException;

public class RestartOrExitCodeConverter {

    public static final int START_CODE = 1;
    public static final int EXIT_CODE = 2;
    private String inputString;

    public Integer getRestartOrExitCode(String inputString) throws InputNumberFormatException {
        this.inputString = inputString;

        int statusCode = getStatusNumber(inputString);
        validateStatusCode(statusCode);

        return statusCode;
    }

    private static int getStatusNumber(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new InputNumberFormatException(inputString);
        }
    }

    private void validateStatusCode(int num) {
        if (!(num == START_CODE || num == EXIT_CODE)) {
            throw new InvalidStatusCodeException(inputString);
        }
        if (inputString.length() != 1) {
            throw new InvalidStatusCodeException(inputString);
        }
    }
}
