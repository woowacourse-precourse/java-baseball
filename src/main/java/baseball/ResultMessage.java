package baseball;

public enum ResultMessage {
    STRIKE("스트라이크"),
    BALL("볼 "),
    NOTHING("낫싱");
    String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessage(int count) {
        return count + this.message;
    }
}
