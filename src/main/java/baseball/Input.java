package baseball;

public class Input {
    private static final int INPUT_LENGTH = 3;

    private String input;


    public Input(String input) {
        CheckLength(input);
        this.input = input;
    }


    private void CheckLength(String input) {
        if (input.length() != INPUT_LENGTH) throw new IllegalArgumentException();
    }
}
