package baseball.core;

import baseball.exception.InvalidStatusCodeException;

import java.util.Arrays;

public enum StatusCode {
    START_CODE("1"),
    EXIT_CODE("2");

    private final String stateCode;

    StatusCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public static StatusCode from(String input) {
        return Arrays.stream(StatusCode.values())
                .filter(statusCode -> statusCode.stateCode.equals(input))
                .findAny()
                .orElseThrow(() -> new InvalidStatusCodeException(input));
    }
}
