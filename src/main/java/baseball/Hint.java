package baseball;

public enum Hint {
    NOTHING("낫싱"),
    S1("1스트라이크"),
    S2("2스트라이크"),
    S3("3스트라이크"),
    B1("1볼"),
    B2("2볼"),
    B3("3볼"),
    B1S1("1볼 1스트라이크"),
    B2S1("2볼 1스트라이크");

    private final String label;

    Hint(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
