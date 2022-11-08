package baseball.domain;

public enum ResultType {

    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String resultType;

    ResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResult() {
        return this.resultType;
    }

}
