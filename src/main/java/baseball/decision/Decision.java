package baseball.decision;

import java.util.Arrays;

public enum Decision {
    PLAY(1),
    STOP(2);

    private static final String INVALID_INT_INSERT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 Decision 숫자 입력입니다.";

    private int decisionNumber;

    Decision(int num) {
        this.decisionNumber = num;
    }

    public static Decision getDecisionByNumber(int num) {
        return Arrays.stream(Decision.values())
                .filter(dc -> dc.decisionNumber == num)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INT_INSERT_ERROR_MESSAGE));
    }
}
