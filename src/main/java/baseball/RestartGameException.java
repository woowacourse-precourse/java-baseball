package baseball;

public class RestartGameException {
    private final int GAME_RESTART = 1;
    private final int GAME_END = 2;

    public boolean isRestartNumber(int number) {
        if (!(GAME_RESTART <= number && number <= GAME_END)) {
            return true;
        }
        return false;
    }

    public boolean isRestartNumber(String number) {
        return true;
    }
}
