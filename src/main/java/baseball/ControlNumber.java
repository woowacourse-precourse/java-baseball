package baseball;

public enum ControlNumber {
    START_NUM(1, true),
    END_NUM(2, false);

    private final int n;
    private final boolean startsGame;

    ControlNumber(int n, boolean startsGame) {
        this.n = n;
        this.startsGame = startsGame;
    }

    public static ControlNumber controlNumberOf(int n) {
        for (ControlNumber controlNumber : ControlNumber.values()) {
            if (controlNumber.n == n) {
                return controlNumber;
            }
        }
        throw new IllegalArgumentException("Your input string: " + n);
    }

    public boolean startsGame() {
        return this.startsGame;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
