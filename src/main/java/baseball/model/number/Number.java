package baseball.model.number;


public class Number {
    private final int index;
    private final int value;

    public Number(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public boolean hasOnlyDifferentIndexWith(Object obj) {
        if (obj instanceof Number) {
            Number other = (Number) obj;
            return (this.index != other.index) && (this.value == other.value);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Number) {
            Number other = (Number) obj;
            return (this.index == other.index) && (this.value == other.value);
        }
        return false;
    }
}
