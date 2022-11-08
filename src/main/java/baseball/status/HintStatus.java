package baseball.status;

public enum HintStatus {
    ANSWER("3스트라이크"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");


    private final String text;

    HintStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
