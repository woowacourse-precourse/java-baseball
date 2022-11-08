package baseball;

public class RestartGameException {
    private final String GAME_RESTART = "1";
    private final String GAME_END = "2";

    public void isRestartNumber(String number) {
        if (!(number.equals(GAME_RESTART) || number.equals(GAME_END))) {
            throw new IllegalArgumentException();
        }
    }
}
