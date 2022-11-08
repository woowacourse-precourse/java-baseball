package baseball.model;

public enum StatusCode {
    RESTART("1"),
    QUIT("2");

    private final String code;

    StatusCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
