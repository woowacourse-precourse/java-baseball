package baseball.option;

public enum Option {
    RESTART(1, true),
    END(2, false);

    private final int option;
    public final boolean status;

    Option(int option, boolean status) {
        this.option = option;
        this.status = status;
    }

    public int getOption() {
        return option;
    }

    public boolean getStatus() {
        return status;
    }
}
