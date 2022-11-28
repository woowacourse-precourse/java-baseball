package baseball.model;


public class GameNumber {
    private final int index;
    private final int number;

    public GameNumber(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public boolean hasOnlyDifferentIndexWith(Object obj) {
        if (obj instanceof GameNumber) {
            GameNumber other = (GameNumber) obj;
            return (this.index != other.index) && (this.number == other.number);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameNumber) {
            GameNumber other = (GameNumber) obj;
            return (this.index == other.index) && (this.number == other.number);
        }
        return false;
    }
}
