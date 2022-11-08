package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewConsole implements InputView {
    private static final String GAME_RESTART_CODE = "1";
    private static final String GAME_END_CODE = "2";
    private static final String ERROR_MESSAGE_ILLEGAL_RESTART_CODE = "입력값이 1이나 2가 아닙니다.";

    @Override
    public String askRestart() throws IllegalArgumentException {
        String restartCode = Console.readLine();
        if (!restartCode.equals(GAME_RESTART_CODE) && !restartCode.equals(GAME_END_CODE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ILLEGAL_RESTART_CODE);
        }
        return restartCode;
    }

    @Override
    public String getUserBaseballNumber() {
        return Console.readLine();
    }
}
