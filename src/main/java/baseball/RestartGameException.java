package baseball;

public class RestartGameException {
    final int GAME_RESTART = 1;
    final int GAME_END = 2;

    public boolean hasRestartNumber(int number) {
        if (!(GAME_RESTART <= number && number <= GAME_END)) {
            return true;
        }
        return false;
    }
}
