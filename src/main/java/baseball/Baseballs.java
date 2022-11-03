package baseball;

public class Baseballs {
    private static final int BASEBALL_COUNT = 3;

    public static Baseballs of(String userInput) {
        return new Baseballs(userInput);
    }

    private Baseballs(String userInput) {
        validate(userInput);
    }

    private void validate(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (userInput.length() != BASEBALL_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
