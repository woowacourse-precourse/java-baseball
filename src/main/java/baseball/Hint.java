package baseball;

public enum Hint {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱")
    ;

    private final String message;

    Hint(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
