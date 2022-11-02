package baseball.domain;

public enum BaseballGameStatus {

    PLAY(1), STOP(2);

    private Integer statusCode;

    BaseballGameStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
