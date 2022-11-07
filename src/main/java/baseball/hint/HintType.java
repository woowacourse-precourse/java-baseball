package baseball.hint;

public enum HintType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String hintType;

    HintType(String hintType) {
        this.hintType = hintType;
    }

    public String getHintType() {
        return hintType;
    }

}
