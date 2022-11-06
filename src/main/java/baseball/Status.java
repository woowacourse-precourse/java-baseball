package baseball;

import java.util.Arrays;

public enum Status {
    PROCEEDING(0),
    RESTART(1),
    EXIT(2),
    EMPTY(-1);

    private int code;

    Status(int code) {
        this.code = code;
    }

    /*
    * 주어진 gameOption에 따른 Status를 반환
    * 예외 처리 필요
    *
    * @return Status
    * */
    public Status getStatusByGameOption(int gameOption) {
        return Arrays.stream(Status.values())
                .filter(status -> status.code == gameOption)
                .findAny()
                .orElse(EMPTY);
    }
}
