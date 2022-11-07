package baseball;

public enum GameStatus {
    IN_GAME("0"),
    RESTART("1"),
    END("2");

    private final String number;

    GameStatus(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
