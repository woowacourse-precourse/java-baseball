package baseball;

public enum GameRestartStatus {
    Y("1"),
    N("2");

    private String status;

    GameRestartStatus(String status) {
        this.status = status;
    }

    public static boolean validStatus(String input) {
        if (input.equals(Y.status) || input.equals(N.status)) return true;
        throw new IllegalArgumentException();
    }

    public boolean isYes() {
        if (this.equals(Y)) {
            return true;
        }
        return false;
    }

    public static GameRestartStatus of(String input) {
        if (validStatus(input)) {
            return genGameStatus(input);
        }
        throw new IllegalArgumentException();
    }

    public static GameRestartStatus genGameStatus(String input) {
        if (input.equals("1")) {
            return GameRestartStatus.Y;
        }
        return GameRestartStatus.N;
    }

    public void print(){
        View.print(this.status+"\n");
    }
}
