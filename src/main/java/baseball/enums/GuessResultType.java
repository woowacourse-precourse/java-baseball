package baseball.enums;

public enum GuessResultType {
    WIN(1), NOT_WIN(0);

    private final int winType;

    GuessResultType(int winType) {
        this.winType = winType;
    }

    public int getWinType() {
        return winType;
    }
}
