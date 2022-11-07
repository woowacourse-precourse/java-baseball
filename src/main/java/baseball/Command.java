package baseball;

public enum Command {
    RESTART(1),
    EXIT(2);

    private final int command;

    Command(int command) {
        this.command = command;
    }

    public int getCommand() {
        return command;
    }
}
