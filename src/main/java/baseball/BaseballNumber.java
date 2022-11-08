package baseball;

public class BaseballNumber {
    private final int baseballNumber;
    private final int index;

    public BaseballNumber(String baseballNumber, int index) {
        this.baseballNumber = Integer.parseInt(baseballNumber);
        this.index = ++index;
    }

    public int getBaseballNumber(int index) throws IllegalArgumentException {
        if (!checkBaseballNumberIndex(++index)) {
            throw new IllegalArgumentException("This index does not match the request object.");
        }
        return baseballNumber;
    }

    public boolean checkBaseballNumberIndex(int index) {
        return this.index == index;
    }

}
