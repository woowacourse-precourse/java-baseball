package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import static baseball.type.GameFlow.GAME_RESTART;
import static baseball.type.GameFlow.GAME_END;
import static baseball.type.BaseballBound.*;


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

    public static String inputPlayerNumber() throws IllegalArgumentException {
        String playerNumber = Console.readLine();

        //validation
        if (playerNumber.length() != BASEBALL_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 3자리의 수를 입력해주세요");
        }
        for(int i=0; i<playerNumber.length(); i++) {
            if (!(('1' <= playerNumber.charAt(i)) && (playerNumber.charAt(i) <= '9'))) {
                throw new IllegalArgumentException("잘못된 입력값입니다. 1-9로 이뤄진 수를 입력해주세요");
            }
        }

        return playerNumber;
    }
}
