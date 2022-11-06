package baseball.exception;

import static baseball.exception.ErrorMessage.INPUT_SIZE;
import static baseball.exception.ErrorMessage.RUN_CODE;

public class GameException {
    private static final int INPUT_NUMBER_SIZE = 1;
    private static final int RESTART = 1;
    private static final int STOP = 2;

    /**
     * runCode 의 길이를 확인하여 INPUT_NUMBER_SIZE 와 동일하지 않으면 예외 처리를 한다.
     * @param runCode 플레이어가 입력한 문자열
     * @throws IllegalArgumentException runCode 의 길이가 INPUT_SIZE 가 아니면 던진다.
     */
    public void runCodeLengthException(String runCode) throws IllegalArgumentException {
        if (runCode.length() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException(INPUT_SIZE.getErrorMessage());
        }
    }

    /**
     * runCode 의 코드를 확인하여 RESTART 와 STOP 와 동일하지 않으면 예외 처리를 한다.
     * @param runCode 플레이어가 입력한 코드
     * @throws IllegalArgumentException runCode 가 RESTART 와 STOP 이 아니면 던진다.
     */
    public void runCodeValidation(int runCode) throws IllegalArgumentException {
        if (runCode != RESTART && runCode != STOP) {
            throw new IllegalArgumentException(RUN_CODE.getErrorMessage());
        }
    }
}
