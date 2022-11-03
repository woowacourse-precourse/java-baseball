package baseball.domain;

import java.util.Arrays;

public enum BaseballGameStatus {

    PLAY(1), STOP(2);

    private Integer statusCode;

    BaseballGameStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static BaseballGameStatus getEnum(Integer statusCode) {
        return Arrays.stream(values())
                .filter(status -> status.statusCode.equals(statusCode))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isGameContinues() {
        return this == PLAY;
    }
}
