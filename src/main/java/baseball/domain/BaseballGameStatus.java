package baseball.domain;

import java.util.Arrays;

public enum BaseballGameStatus {
    PLAY(1),
    STOP(2);

    private Integer statusCode;

    BaseballGameStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static BaseballGameStatus getEnum(Integer statusCode) {
        return Arrays.stream(values())
                .filter(baseballGameStatus -> isStatusCodeEqual(baseballGameStatus, statusCode))
                .findAny()
                .orElseThrow(BaseballGameException::new);
    }

    private static boolean isStatusCodeEqual(BaseballGameStatus baseballGameStatus, Integer statusCode) {
        return baseballGameStatus.statusCode.equals(statusCode);
    }

    public boolean isGameContinues() {
        return this == PLAY;
    }
}
