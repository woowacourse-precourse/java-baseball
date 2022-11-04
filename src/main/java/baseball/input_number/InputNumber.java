package baseball.input_number;

public class InputNumber {

    private final int position;
    private final int number;

    public InputNumber(int position, int number) {
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
