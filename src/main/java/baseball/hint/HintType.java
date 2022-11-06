package baseball.hint;

import baseball.referee.JudgeType;

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
