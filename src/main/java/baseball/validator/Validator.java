package baseball.validator;

import baseball.constant.Constant;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public final String WRONG_PLAYER_INPUTS = "입력값은 1-9까지의 서로 다른 임의의 3자리 정수 입니다.";
    public final String WRONG_RESTART_INPUTS = "입력값은 1, 또는 2 입니다.";

    public void validatePlayerInputs(String playerInputs) {
        if (!isRightLength(playerInputs)
                || !isRightRange(playerInputs)
                || isDuplicated(playerInputs)) {
            throw new IllegalArgumentException(WRONG_PLAYER_INPUTS);
        }
    }

    private boolean isRightLength(String playerInputs) {
        return playerInputs.length() == 3;
    }

    private boolean isRightRange(String playerInputs) {
        for (int i = 0; i < Constant.SIZE_NUMBER; i++) {
            int charToInteger = Character.getNumericValue(playerInputs.charAt(i));
            if (charToInteger < Constant.MIN_NUMBER || charToInteger > Constant.MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicated(String playerInputs) {
        List<Character> inputs = new ArrayList<>();
        for (int i = 0; i < Constant.SIZE_NUMBER; i++) {
            inputs.add(playerInputs.charAt(i));
        }
        return inputs.size() != inputs.stream().distinct().count();
    }

    public void validateRestartInput(String restartInput) {
        if (!isRightValue(restartInput)) {
            throw new IllegalArgumentException(WRONG_RESTART_INPUTS);
        }
    }

    private boolean isRightValue(String restartInput) {
        return restartInput.equals(Constant.RESTART_GAME) || restartInput.equals(Constant.END_GAME);
    }
}
