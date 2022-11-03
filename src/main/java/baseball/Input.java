package baseball;

public class Input {
    private static final int INPUT_LENGTH = 3;

    private String input;


    public Input(String input) {
        CheckLength(input);
        CheckLange(input);
        CheckContinuous(input);
        this.input = input;
    }

    private void CheckLange(String input) {
        for (int i = 0; i < 3; i += 1) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') throw new IllegalArgumentException();
        }
    }

    private void CheckLength(String input) {
        if (input.length() != INPUT_LENGTH) throw new IllegalArgumentException();
    }

    private void CheckContinuous(String input) {
        for (int i = 0; i < 3; i += 1) {
            int tmp = input.indexOf(input.charAt(i));
            if (tmp != i) throw new IllegalArgumentException();
        }
    }
}
