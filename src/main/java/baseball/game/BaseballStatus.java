package baseball.game;

public enum BaseballStatus {
    GUESSING, CORRECT;

    public boolean isGuessing() {
        return this == GUESSING;
    }
}
