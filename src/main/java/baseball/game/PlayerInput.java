package baseball.game;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.GameConstants.INPUT_DUPLICATE;
import static baseball.config.GameConstants.INPUT_OUT_OF_RANGE;

public final class PlayerInput extends Digits {
    private PlayerInput(int value) {
        if (!isInputValidInRange(value)) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE);
        }
        splitDigit(value).forEach(this::appendIfNotExist);
    }


    public static PlayerInput from(int value) {
        return new PlayerInput(value);
    }

    private boolean isInputValidInRange(int value) {
        return 100 <= value && value <= 999;
    }

    private List<Digit> splitDigit(int value) {
        List<Digit> result = new ArrayList<>();
        while (value > 0) {
            result.add(0, Digit.from(value % 10));
            value /= 10;
        }
        return result;
    }


    private void appendIfNotExist(Digit digit) {
        if (contains(digit)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE);
        }
        append(digit);
    }
}
