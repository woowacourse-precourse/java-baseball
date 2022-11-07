package baseball;

public class ErrorUtil {
    public void checkError(boolean check) {
        if (!check)
            throw new IllegalArgumentException();
    }
}