package baseball.domain;

public enum GameProgress {
    CONTINUE(1),
    STOP(2);

    private int progress;

    GameProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
}
