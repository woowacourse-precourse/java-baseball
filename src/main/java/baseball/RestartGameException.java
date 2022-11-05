package baseball;

public class RestartGameException {
    public boolean hasRestartNumber(int number) {
        if (!(1 <= number && number <= 2)) {
            return true;
        }
        return false;
    }
}
