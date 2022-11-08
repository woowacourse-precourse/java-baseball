package baseball.service;

import java.util.Arrays;

public enum StartOptions {
    START("0"),
    RESTART("1"),
    STOP("2");

    private static final String ERROR_MESSAGE = "StartOptions에 없는 sign값 입니다.";
    private final String sign;

    StartOptions(String sign) {
        this.sign = sign;
    }

    public boolean is(StartOptions startOptions) {
        return this == startOptions;
    }

    public static StartOptions of(String inputValue) {
        return Arrays.stream(StartOptions.values())
                .filter(startOptions -> inputValue.equals(startOptions.sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }
}
