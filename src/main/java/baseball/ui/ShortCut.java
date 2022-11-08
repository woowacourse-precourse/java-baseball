package baseball.ui;

public enum ShortCut {
    END_GAME("1"),
    CONTINUE_GAME("2"),
    ;

    private String value;

    ShortCut(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
