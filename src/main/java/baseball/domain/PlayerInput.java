package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerInput extends Digits {
    private PlayerInput(int value) {
        if (!isInputValidInRange(value)) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        append(digit);
    }
}
