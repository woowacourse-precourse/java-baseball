package baseball;

public enum GameStatus {
    Y("1"),
    N("2");

    private String status;

    GameStatus(String status) {
        this.status = status;
    }

    public static boolean validStatus(String input) {
        if (input.equals(Y.status) || input.equals(N.status)) return true;
        throw new IllegalArgumentException();
    }

    public static boolean isYes(String input) {
        if (input.equals(Y.status)) {
            return true;
        }
        return false;
    }
}
