package baseball.domain.Hint;

public enum HintString {
    BALL("%d볼 "),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱");

    private final String content;

    HintString(String content) {
        this.content = content;
    }

    public String print(int count) {
        return String.format(content, count);
    }

    public String print() {
        return content;
    }
}
