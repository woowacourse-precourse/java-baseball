package baseball.util;

public enum PlayStatus {
    NEW_GAME(1),
    EXIT_GAME(2);

    private final int playStatus;

    PlayStatus(int playStatus) {
        this.playStatus = playStatus;
    }

    public int getPlayStatus() {
        return playStatus;
    }

    public static boolean isPlayStatusNumber(int number) {
        for (PlayStatus ps : PlayStatus.values()) {
            if (ps.getPlayStatus() == number) {
                return true;
            }
        }
        return false;
    }
}
