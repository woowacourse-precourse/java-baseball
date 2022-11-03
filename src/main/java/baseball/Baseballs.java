package baseball;

public class Baseballs {

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
    }
}
