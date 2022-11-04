package baseball.domain;

public enum Score {

    STRIKE("스트라이크"), BALL("볼"), 낫("낫씽");


    private final String value;

    Score(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
