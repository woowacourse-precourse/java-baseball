package baseball;

import java.util.Arrays;

public enum Status {
    PROCEEDING(0),
    RESTART(1),
    EXIT(2);

    private static final String EXCEPTION_MESSAGE = "잘못된 옵션입니다.";
    private final int gameOption;

    Status(int gameOption) {
        this.gameOption = gameOption;
    }

    /*
    * 주어진 gameOption에 따른 Status를 반환
    * 옵션이 enum에 없는 경우 IllegalArgumentException
    *
    * @return Status
    * */
    public static Status getStatus(int gameOption) {
        return Arrays.stream(Status.values())
                .filter(status -> status.gameOption == gameOption)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE));
    }
}
