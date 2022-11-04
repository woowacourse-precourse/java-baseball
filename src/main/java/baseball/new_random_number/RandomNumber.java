package baseball.new_random_number;

public class RandomNumber {

    private final int position;
    private final int number;

    RandomNumber(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public int position() {
        return position;
    }

    public int number() {
        return number;
    }
}
