package baseball;

public enum GameOption {
    RESTART,
    EXIT;

    public static GameOption of(String input) {
        if (input.equals("1")) {
            return GameOption.RESTART;
        }
        return GameOption.EXIT;
    }
}
