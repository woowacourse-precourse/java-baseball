package baseball;

import static baseball.utils.ErrorMessages.REQUIRE_ONE_OR_TWO;

import java.util.Arrays;

public enum ContinueOrBreak {
    CONTINUE(1), BREAK(2);

    private final int code;

    ContinueOrBreak(int code) {
        this.code = code;
    }

    public static ContinueOrBreak from(final int code) {
        return Arrays.stream(values())
                .filter(continueOrBreak -> continueOrBreak.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(REQUIRE_ONE_OR_TWO));
    }
}
