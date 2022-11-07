package baseball.enums;

public enum GuessResultStatus {
    WIN(1), NOT_WIN(0);

    private final int winType;

    GuessResultStatus(int winType) {
        this.winType = winType;
    }

    public int getWinType() {
        return winType;
    }
}
