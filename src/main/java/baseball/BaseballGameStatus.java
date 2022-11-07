package baseball;

public enum BaseballGameStatus {
    RESTART, QUIT;

    public static BaseballGameStatus fromString(String x) {
        if (x.equals("1")) {
            return RESTART;
        }
        if (x.equals("2")) {
            return QUIT;
        }
        throw new IllegalArgumentException();
    }
}
