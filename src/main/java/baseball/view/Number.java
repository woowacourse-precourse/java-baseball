package baseball.view;

public enum Number {
    LENGTH(3);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
