package baseball.utils.resources;

public enum InputKey {
    RESTART("1"),
    QUIT("2")
    ;

    private final String text;

    InputKey(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
