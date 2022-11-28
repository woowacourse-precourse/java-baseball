package baseball.model;

public enum GameCommand {

    REPLAY("1"), END("2");

    private final String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String get() {
        return gameCommand;
    }
}
