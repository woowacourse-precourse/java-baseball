package baseball.setting;

public enum CorrectEnum {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String correct;

    CorrectEnum(String correct) {
        this.correct = correct;
    }

}
