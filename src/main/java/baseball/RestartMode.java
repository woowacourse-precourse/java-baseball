package baseball;

public class RestartMode {
    enum Mode {
        GAME_RESTART, GAME_END
    }

    private final Mode mode;

    private RestartMode(Mode mode) {
        this.mode = mode;
    }

    public static RestartMode makeInstance(String input) {
        if(input.equals("1")) {
            return new RestartMode(Mode.GAME_RESTART);
        } else if(input.equals("2")) {
            return new RestartMode(Mode.GAME_END);
        }
        throw new IllegalArgumentException();
    }

    public boolean shouldGameRestart() {
        switch (mode) {
            case GAME_RESTART:
                return true;
            case GAME_END:
            default:
                return false;
        }
    }
}
