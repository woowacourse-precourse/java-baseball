package baseball;

public class MyInputMismatchException extends IllegalArgumentException {
    private static final String OUTPUT_MESSAGE = "Your input string is mismatch: ^%s$";

    public MyInputMismatchException() {
        this("");
    }

    public MyInputMismatchException(String str) {
        super(String.format(OUTPUT_MESSAGE, str));
    }
}
