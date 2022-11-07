package baseball.Domain;

public enum GameStatus {
    PlAY(1),
    FINISH(2);
    private final int label;

    GameStatus(int label) {
        this.label = label;
    }

    public int label() {
        return label;
    }

}
