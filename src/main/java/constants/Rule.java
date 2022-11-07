package constants;

public enum Rule {

    NUMBER(3, 1, 9),
    HINT(2, 0, 3);

    private int length;
    private int min;
    private int max;

    Rule(int length, int min, int max) {
        this.length = length;
        this.min = min;
        this.max = max;
    }

    public int getLength() {
        return this.length;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }
}
