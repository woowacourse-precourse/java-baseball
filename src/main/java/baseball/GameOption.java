package baseball;

public enum GameOption {
    RESTART_GAME("1"),
    GAME_OVER("2");

    private final String value;

    GameOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
