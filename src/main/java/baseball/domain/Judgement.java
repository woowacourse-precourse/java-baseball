package baseball.domain;

public enum Judgement {
    NOTHING, SAME_VALUE;

    public boolean isSameValue() {
        return this == SAME_VALUE;
    }
}
