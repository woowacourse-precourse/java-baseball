package baseball;

public enum GameOption {
    RESTART("1"),
    EXIT("2");

    private final String input;

    GameOption(String input) {
        this.input = input;
    }

    public static GameOption of(String input) {
        if (input.equals("1")) {
            return GameOption.RESTART;
        }
        return GameOption.EXIT;
    }
}
