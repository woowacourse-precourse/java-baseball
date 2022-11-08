package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static baseball.type.BaseballBound.BASEBALL_MAX_SIZE;
import static baseball.type.GameFlow.GAME_END;
import static baseball.type.GameFlow.GAME_RESTART;

public class InputValidator {
    private static final String RESTART = Integer.toString(GAME_RESTART.getValue());
    private static final String END = Integer.toString(GAME_END.getValue());

    public static void validateRestartFlag(String restartFlag) throws IllegalArgumentException {
        if (!((restartFlag.equals(RESTART)) || (restartFlag.equals(END)))) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 1이나 2를 입력해주세요");
        }
    }

    public static void validatePlayerNumber(String playerNumber) throws IllegalArgumentException {
        validateNumberSize(playerNumber);
        validateDuplicatedNumber(playerNumber);
        validateNumberBound(playerNumber);
    }

    private static void validateNumberSize(String playerNumber) throws IllegalArgumentException {
        if (playerNumber.length() != BASEBALL_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 3자리의 수를 입력해주세요");
        }
    }

    private static void validateDuplicatedNumber(String playerNumber) throws IllegalArgumentException {
        List<Character> inputNumbers = new ArrayList<>();
        for(int i=0; i<playerNumber.length(); i++) {
            if (inputNumbers.contains(playerNumber.charAt(i))) {
                throw new IllegalArgumentException("서로다른 수를 입력해야 합니다");
            }
            inputNumbers.add(playerNumber.charAt(i));
        }
    }

    private static void validateNumberBound(String playerNumber) throws IllegalArgumentException {
        for(int i=0; i<playerNumber.length(); i++) {
            if (playerNumber.charAt(i) == '0') {
                throw new IllegalArgumentException("잘못된 입력값입니다. 1-9로 이뤄진 수를 입력해주세요");
            }
        }
    }
}
