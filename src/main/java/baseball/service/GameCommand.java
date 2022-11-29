package baseball.service;

public enum GameCommand {

    RETRY("1"),
    QUIT("2");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
