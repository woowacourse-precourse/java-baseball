package baseball;

import static baseball.utils.ErrorMessages.*;

public class ContinueOrBreakValidator implements IntInputValidator {
    @Override
    public void validate(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException(REQUIRE_ONE_OR_TWO);
        }
    }
}
