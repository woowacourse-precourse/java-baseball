package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import static baseball.type.GameFlow.GAME_RESTART;
import static baseball.type.GameFlow.GAME_END;


public class Input {
    private static final String RESTART = Integer.toString(GAME_RESTART.getValue());
    private static final String END = Integer.toString(GAME_END.getValue());

    public static String inputRestartFlag() throws IllegalArgumentException {
        String restartFlag = Console.readLine();
        //validataion
        if (!((restartFlag.equals(RESTART)) || (restartFlag.equals(END)))) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 1이나 2를 입력해주세요");
        }

        return restartFlag;
    }

    public static String inputPlayerNumber() {
        return Console.readLine();
    }
}
