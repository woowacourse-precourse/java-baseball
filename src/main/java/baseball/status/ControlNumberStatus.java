package baseball.status;

public enum ControlNumberStatus {
    START_NUMBER("1"),
    END_NUMBER("2"),
    DONT_CONTAIN_THIS_NUMBER("0");

    private final String text;

    ControlNumberStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
