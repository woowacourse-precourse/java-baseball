package baseball;

public enum ControlNumber {
    START_NUM(1, true),
    END_NUM(2, false);

    private final int n;
    private final boolean retries;

    ControlNumber(int n, boolean retries) {
        this.n = n;
        this.retries = retries;
    }

    public static ControlNumber controlNumberOf(String characterNumber) {
        int n;

        try {
            n = Integer.parseInt(characterNumber);
        } catch (NumberFormatException e) {
            throw new MyInputMismatchException(characterNumber);
        }
        return controlNumberOf(n);
    }

    public static ControlNumber controlNumberOf(int n) {
        for (ControlNumber controlNumber : ControlNumber.values()) {
            if (controlNumber.n == n) {
                return controlNumber;
            }
        }
        throw new MyInputMismatchException(n);
    }

    public boolean retries() {
        return this.retries;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
