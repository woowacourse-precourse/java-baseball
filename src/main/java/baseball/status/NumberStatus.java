package baseball.status;

public enum NumberStatus {
    MAX_NUMBER(3),
    MIN_NUMBER(0);

    private int number;

    NumberStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
