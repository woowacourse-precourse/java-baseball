package baseball;

import static baseball.utils.Constants.*;
import static baseball.utils.ErrorMessages.BETWEEN_ONE_AND_NINE;
import static baseball.utils.ErrorMessages.REQUIRE_THREE_DIGIT_NUMBER;

public class PlayerNumberValidator implements IntInputValidator {
    @Override
    public void validate(int number) {
        if (String.valueOf(number).length() != RANDOM_NUMBER_LENGTH) {
            throw new IllegalArgumentException(REQUIRE_THREE_DIGIT_NUMBER);
        }
        if (isNotBetweenOneAndNine(String.valueOf(number))) {
            throw new IllegalArgumentException(BETWEEN_ONE_AND_NINE);
        }
    }

    private boolean isNotBetweenOneAndNine(String string) {
        return string.contains("-") || string.contains("0");
    }
}
