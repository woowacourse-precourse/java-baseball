package constants;

public enum Number {

    RULE(3, 1, 9);

    private int length;
    private int min;
    private int max;

    Number(int length, int min, int max) {
        this.length = length;
        this.min = min;
        this.max = max;
    }

    public int getLength() {
        return this.length;
    }

    public int getMinNumber() {
        return this.min;
    }

    public int getMaxNumber() {
        return this.max;
    }
}
