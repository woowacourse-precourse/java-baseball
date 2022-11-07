package baseball;

public enum GameStatus {
    ON(1), EXIT(2),
    ;

    private int code;

    GameStatus(int code) {
        this.code = code;
    }
}
