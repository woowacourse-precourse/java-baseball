package baseball;

import static baseball.utils.Constants.*;
import static baseball.utils.ErrorMessages.REQUIRE_THREE_DIGIT_NUMBER;

public class PlayerNumberValidator implements IntInputValidator {
    @Override
    public void validate(int number) {
        if (String.valueOf(number).length() != RANDOM_NUMBER_LENGTH) {
            throw new IllegalArgumentException(REQUIRE_THREE_DIGIT_NUMBER);
        }
    }
}
