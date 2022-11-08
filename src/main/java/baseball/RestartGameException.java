package baseball;

public class RestartGameException {
    private final String GAME_RESTART = "1";
    private final String GAME_END = "2";

    public boolean isRestartNumber(String number) {
        if (!(number.equals(GAME_RESTART) || number.equals(GAME_END))) {
            return true;
        }
        return false;
    }
}
