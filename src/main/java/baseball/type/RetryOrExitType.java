package baseball.type;

public enum RetryOrExitType {
    RETRY("1"),
    EXIT("2");

    private final String string;

    RetryOrExitType(String s) {
        this.string = s;
    }

    public String getString() {
        return string;
    }
}
