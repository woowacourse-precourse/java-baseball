package baseball.enums;

public enum BallCount {
    NOTHING("낫싱"),
    BALL("볼 "),
    STRIKE("스트라이크");
    private final String korean;

    BallCount(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
