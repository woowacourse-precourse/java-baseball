package baseball;

import java.util.Arrays;

public enum Status {
    PROCEEDING(0),
    RESTART(1),
    EXIT(2);

    private int code;

    Status(int code) {
        this.code = code;
    }

    /*
    * 주어진 gameOption에 따른 Status를 반환
    * 옵션이 enum에 없는 경우 IllegalArgumentException
    *
    * @return Status
    * */
    public static Status getStatusByGameOption(int gameOption) {
        return Arrays.stream(Status.values())
                .filter(status -> status.code == gameOption)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 옵션입니다."));
    }
}
